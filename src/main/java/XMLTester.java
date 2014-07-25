
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;


public class XMLTester {

    public static void main(String[] args) throws Exception {
        
        FileInputStream fis = new FileInputStream(new File("/home/stran/Desktop/testData.xml"));
        FileOutputStream fos = new FileOutputStream(new File("/home/stran/Desktop/output.pdf"));
        
        FopFactory fopFactory = FopFactory.newInstance(); 
        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, fos);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(); // identity transformer
        Source src = new StreamSource(fis);
        Result res = new SAXResult(fop.getDefaultHandler());
        transformer.transform(src, res);

    }
}
