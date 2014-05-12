
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * This is one way to read a properties when it's located in a jboss properties module.
 * 
 * @author stran
 */
public class PropertiesUtility {

    public static void main(String ... args) throws Exception {
        System.out.println(loadProperties());
    }

    public static Properties loadProperties() throws Exception {
        URL url = Thread.currentThread().getContextClassLoader().getResource("evaas.properties");
        Properties p = new Properties(System.getProperties());
        p.load(new FileReader(new File(url.getFile())));
        return p;
    }

}
