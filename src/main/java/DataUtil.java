

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataUtil {

	private static final Logger logger = LoggerFactory.getLogger(DataUtil.class);

	/**
	 * Trims and Truncates string fields safely
	 * 
	 * @param field The field that needs to be tnt'd
	 * @param length The maximum length of the string
	 * @return A String that is of the specified length or shorter, 
	 *  or null if either an invalid field was passed in, or a 
	 *  negative length was provided  
	 */
	public static String tnt(String field, int length) {
		String retVal = field;
		if(field != null && length > 0) {
			retVal = field.trim();
			if(retVal.length() > length) {
				retVal = retVal.substring(0, length);
			}
		}
		return retVal;
	}
	
	/**
	 * Trims and Truncates JAXBElement String fields safely.
	 * 
	 * @param field The field that needs to be tnt'd
	 * @param length The maximum length of the string
	 * @return A String that is of the specified length or shorter, 
	 *  or null if either an invalid field was passed in, or a 
	 *  negative length was provided  
	 */
	public static String tnt(JAXBElement<String> field, int length) {
		String retVal = null;
		if(field != null && field.getValue() != null) {
			retVal = tnt(field.getValue(), length);
		}
		return retVal;
	}

	/**
	 * Extracts a XMLGregorianCalendar from a JAXBElement and converts it into a Java Date
	 * @param c The JAXBElement that contains the XMLGregorianCalendar
	 * @return A Java Date equivalent of the XMLGregorianCalendar or null
	 */
	public static Date convertDate(JAXBElement<XMLGregorianCalendar> c) {
		return (c != null && c.getValue() != null) ? convertDate(c.getValue()) : null;
	}

	/**
	 * Converts a XMLGregorianCalendar object into a Java Date
	 * @param c The value to convert
	 * @return The Java Date equivalent of the XMLGregorianCalendar or null
	 */
	public static Date convertDate(XMLGregorianCalendar c) {
		return (c != null) ? c.toGregorianCalendar().getTime() : null;
	}
	
	/**
	 * Converts a Java date into it's equivalent XMLGregorianCalendar form
	 * @param d The date to convert
	 * @return The XMLGregorianCalendar equivalent of the Java Date passed in or null
	 */
	public static XMLGregorianCalendar getXMLDate(Date d) {
		XMLGregorianCalendar date = null;

		if(d != null) {
			try {
				GregorianCalendar c = new GregorianCalendar();
				c.setTime(d);
				date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			} catch (DatatypeConfigurationException e) {
				logger.error("Could not create XMLGregorianCalendar from date " + d, e);
			}
		}
		return date;
	}
	
	/**
	 * Converts a comma separated values String into a List of trimmed Strings
	 * @param csv The String containing the CSV list
	 * @return A list of trimmed Strings, or an empty List if an invalid argument was passed in
	 */
	public static List<String> convertCsvToList(String csv) {
		List<String> retVal = new ArrayList<String>();
		if(csv != null) {
			String[] tokens = csv.split(",");
			if(tokens != null) {
				for(String s : tokens) {
					String value = s.trim();
					if(!"".equals(value)) {
						retVal.add(value);
					}
				}
			}
		}
		return retVal;
	}
}
