package x500;

import java.security.Principal;

import javax.naming.InvalidNameException;
import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;

public class X500CNTest {

	public static void main(String[] args) {
		
	}

	/**
	 * An x500 Principal is in rfc2253 format, which is the same as used for LDAP DN.  
	 *  Others have suggested we reuse the LDAP API to break up the DN into pieces, 
	 *  so this method does that and only returns the CN 
	 *  
	 * @param principal
	 * @return
	 */
	private String getCN(Principal principal)  {
		try {
			LdapName ldapDN = new LdapName(principal.getName());

			for(Rdn rdn: ldapDN.getRdns()) {
				if(rdn.getType().equals("CN")) {
					return rdn.getValue().toString().trim();
				}
				//System.out.println(rdn.getType() + " -> " + rdn.getValue());
			}
		} catch (InvalidNameException e) {
			e.printStackTrace();
		}

		return null;
	}
}
