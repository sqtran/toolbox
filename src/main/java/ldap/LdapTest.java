package ldap;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class LdapTest {

    public static void main(String[] args) {

        List<String> output = new ArrayList<String>();

        try {
            String url = "ldap://localhost";
            Hashtable<String, String> env = new Hashtable<String, String>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, url);
            DirContext context = new InitialDirContext(env);

            SearchControls ctrl = new SearchControls();
            ctrl.setSearchScope(SearchControls.SUBTREE_SCOPE);
            NamingEnumeration<SearchResult> enumeration = context.search("dc=my-domain,dc=com", "(objectClass=person)", ctrl);
            while (enumeration.hasMore()) {
                SearchResult result = (SearchResult) enumeration.next();
                Attributes attribs = result.getAttributes();
                NamingEnumeration<?> values = ((BasicAttribute) attribs.get("cn")).getAll();
                while (values.hasMore()) {
                    output.add(values.next().toString());
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.print(output.toString());
    }
}