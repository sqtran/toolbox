package xml;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public class XMLPrint {

    static String good = "<CEVCallbackResponse xmlns=\"http://cevresp.ee.sim.cev.cms.hhs.gov\" xmlnssi=\"http://www.w3.org/2001/XMLSchema-instance\"><RequestID>133429770</RequestID><APTCResponse><exch:APTCResponse xmlns:exch=\"http://aptc.dsh.cms.gov/exchange/1.0\"><ext:IRSResponse xmlns:ext=\"http://aptc.dsh.cms.gov/extension/1.0\"><hcore:RequestID xmlns:hcore=\"http://hix.cms.gov/0.1/hix-core\">363836264</hcore:RequestID><hee:APTC xmlns:hee=\"http://hix.cms.gov/0.1/hix-ee\"><hee:APTCMaximumAmount>528</hee:APTCMaximumAmount><hee:APTCRemainingBHCAmount>0</hee:APTCRemainingBHCAmount></hee:APTC><ext:SystemCode>IRS</ext:SystemCode></ext:IRSResponse><ext:ErrorMessageDetail xmlns:ext=\"http://aptc.dsh.cms.gov/extension/1.0\"><hcore:ResponseMetadata xmlns:hcore=\"http://hix.cms.gov/0.1/hix-core\"><hcore:ResponseCode>HS000000</hcore:ResponseCode><hcore:ResponseDescriptionText>Success</hcore:ResponseDescriptionText><hcore:TDSResponseDescriptionText/></hcore:ResponseMetadata><extPathContent/></ext:ErrorMessageDetail></exch:APTCResponse></APTCResponse><APTCEligibility><FederalPovertyLevelPercent>188.32</FederalPovertyLevelPercent><SLCSPPremiumAmount>668.01</SLCSPPremiumAmount></APTCEligibility><CSREligibility><CSREligibilityIndicator>true</CSREligibilityIndicator><CSRCategoryCode>1B</CSRCategoryCode></CSREligibility><ResponseMetadata><ResponseCode>CS000000</ResponseCode><ResponseDescriptionText>Success</ResponseDescriptionText></ResponseMetadata></CEVCallbackResponse>";

    
    public static void main(String[] args) {
        System.out.println(beautify(good));
    }
    
    private static String beautify(String xml) {
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            Source xmlInput = new StreamSource(new StringReader(xml));
            StreamResult xmlOutput = new StreamResult(new StringWriter());
            transformer.transform(xmlInput, xmlOutput);
            return xmlOutput.getWriter().toString();
        } catch(TransformerException ex) {
            ex.printStackTrace();
        }
        return xml;
    }

}
