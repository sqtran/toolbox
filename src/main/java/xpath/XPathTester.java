package xpath;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XPathTester {

    static String good = "<CEVCallbackResponse xmlns=\"http://cevresp.ee.sim.cev.cms.hhs.gov\" xmlnssi=\"http://www.w3.org/2001/XMLSchema-instance\"><RequestID>133429770</RequestID><APTCResponse><exch:APTCResponse xmlns:exch=\"http://aptc.dsh.cms.gov/exchange/1.0\"><ext:IRSResponse xmlns:ext=\"http://aptc.dsh.cms.gov/extension/1.0\"><hcore:RequestID xmlns:hcore=\"http://hix.cms.gov/0.1/hix-core\">363836264</hcore:RequestID><hee:APTC xmlns:hee=\"http://hix.cms.gov/0.1/hix-ee\"><hee:APTCMaximumAmount>528</hee:APTCMaximumAmount><hee:APTCRemainingBHCAmount>0</hee:APTCRemainingBHCAmount></hee:APTC><ext:SystemCode>IRS</ext:SystemCode></ext:IRSResponse><ext:ErrorMessageDetail xmlns:ext=\"http://aptc.dsh.cms.gov/extension/1.0\"><hcore:ResponseMetadata xmlns:hcore=\"http://hix.cms.gov/0.1/hix-core\"><hcore:ResponseCode>HS000000</hcore:ResponseCode><hcore:ResponseDescriptionText>Success</hcore:ResponseDescriptionText><hcore:TDSResponseDescriptionText/></hcore:ResponseMetadata><extPathContent/></ext:ErrorMessageDetail></exch:APTCResponse></APTCResponse><APTCEligibility><FederalPovertyLevelPercent>188.32</FederalPovertyLevelPercent><SLCSPPremiumAmount>668.01</SLCSPPremiumAmount></APTCEligibility><CSREligibility><CSREligibilityIndicator>true</CSREligibilityIndicator><CSRCategoryCode>1B</CSRCategoryCode></CSREligibility><ResponseMetadata><ResponseCode>CS000000</ResponseCode><ResponseDescriptionText>Success</ResponseDescriptionText></ResponseMetadata></CEVCallbackResponse>";

    static String bad = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><CEVCallbackResponse xmlns=\"http://cevresp.ee.sim.cev.cms.hhs.gov\"><RequestID>133429770<ResponseMetadata/><ResponseCode>CX009000</ResponseCode><ResponseDescriptionText>Unexpected System Exception</ResponseDescriptionText></RequestID></CEVCallbackResponse>";

    public static void main(String[] args) throws Exception {

        XPath xPath = XPathFactory.newInstance().newXPath();
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document xmlDocument = db.parse(new InputSource(new ByteArrayInputStream(bad.getBytes("utf-8"))));


        String responseMessage = "";
        String responseCode = xPath.compile("/CEVCallbackResponse//ResponseCode").evaluate(xmlDocument);        
        String description = "/CEVCallbackResponse//ResponseDescriptionText";

        NodeList nodeList = (NodeList) xPath.compile(description).evaluate(xmlDocument, XPathConstants.NODESET);
        for(int i = 0; i < nodeList.getLength(); i++) {
            responseMessage += nodeList.item(i).getFirstChild().getNodeValue() + ",";
        }
        if (responseMessage.lastIndexOf(",") > 0) {
            responseMessage = responseMessage.substring(0, responseMessage.lastIndexOf(","));
        }
        
        System.out.println("____");
        System.out.println(responseCode);
        System.out.println(responseMessage);
        System.out.println("~~~~");
    }

}
