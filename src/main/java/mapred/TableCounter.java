package mapred;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cloudbase.core.client.impl.HdfsZooInstance;
import cloudbase.core.client.impl.MasterClient;
import cloudbase.core.client.impl.Tables;
import cloudbase.core.master.thrift.MasterClientService;
import cloudbase.core.master.thrift.MasterMonitorInfo;
import cloudbase.core.master.thrift.TableInfo;
import cloudbase.core.master.thrift.TabletServerStatus;
import cloudbase.core.security.thrift.ThriftSecurityException;
import cloudbase.server.security.SecurityConstants;

/**
 * Scans through all tablets to determine how many records are currently present
 * 
 * @author stran@hpti.com
 */
public class TableCounter {

	private static Logger log = LoggerFactory.getLogger(TableCounter.class);
	
	/**
	 * Returns a map of <TableName, Record Count> for every table.  I assume that it 
	 *  reads the table's internal metadata instead of counting every single row since
	 *  it happens relatively quickly. 
	 * 
	 * @return Map of TableName to RecordCounts
	 * @throws ThriftSecurityException If something bad happened...
	 * @throws TException If something bad happened...
	 */
	public static Map<String, Long> getTableCount() throws ThriftSecurityException, TException {
		MasterMonitorInfo mmi;
		Map<String, Long> recordsByTable = new HashMap<String,Long>();

		log.info("\nFetching data now...\n");
		MasterClientService.Iface client = MasterClient.getConnection(HdfsZooInstance.getInstance());
		mmi = client.getMasterStats(null, SecurityConstants.systemCredentials);

		// Pay attention because this is actually pretty slick.  Loop through
		// each tablet server and pull out the tables, then loop through each 
		// table and get the record count.  Tables can be split between many 
		// tablets, so you'll need to aggregate the results together.
		for (TabletServerStatus server : mmi.tServerInfo) {		
			Map<String, TableInfo> tablestuff = server.getTableMap();
			for(String key : tablestuff.keySet()) {				
				//System.out.println(key + "  " + tablestuff.get(key).recs);
				Long c = (c = recordsByTable.get(key)) == null ? 0 : c;
				recordsByTable.put(key, (c + tablestuff.get(key).recs) );
			}
		}
		log.info("Data fetched....\n");

		// transpose key->value to value->key because the human-readable table name is the key
		Map<String, String> name2Key = Tables.getNameToIdMap(HdfsZooInstance.getInstance());
		Map<String, String> key2Name = new TreeMap<String, String>();
		for(String s : name2Key.keySet()) {
			key2Name.put(name2Key.get(s), s);
		}

		Map<String, Long> resultSet = new TreeMap<String, Long>();
		for(String key : recordsByTable.keySet()) {
			resultSet.put(key2Name.get(key), recordsByTable.get(key));
		}

		// Some people would call it magic
		log.debug("\nDone...\n");
		return resultSet;
	}

	/**
	 * Just in case you wanted to see for yourself
	 * @param args No args needed
	 * @throws ThriftSecurityException If something bad happened...
	 * @throws TException If something bad happened...
	 */
	public static void main(String ... args) throws ThriftSecurityException, TException {
		Map<String, Long> c = getTableCount();
		for(String s : c.keySet()) {
			System.out.println(s + " : " + c.get(s));
		}
	}
}