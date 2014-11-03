
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;


public class FOPTester {

    public static void main(String[] args) throws Exception {
        
        InputStream in = FOPTester.class.getClassLoader().getResourceAsStream("testData.xml");
        FileOutputStream fos = new FileOutputStream(new File("target/output.pdf"));
        
        FopFactory fopFactory = FopFactory.newInstance(); 
        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, fos);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(); // identity transformer
        Source src = new StreamSource(in);
        Result res = new SAXResult(fop.getDefaultHandler());
        transformer.transform(src, res);
        
        
        
    }
}
