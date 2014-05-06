import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class Tester {

	public static void main(String[] args) throws Exception {
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document doc = builder.parse("./src/input.xml");


		NodeList labTestList = doc.getElementsByTagName("LabTest");
		for (int i = 0; i < labTestList.getLength(); ++i)
		{
		    Element labTest = (Element) labTestList.item(i);
		    String labTestType = labTest.getAttribute("type");

		    NodeList valueList = labTest.getElementsByTagName("value");
		    for (int j = 0; j < valueList.getLength(); ++j)
		    {
		        Element value = (Element) valueList.item(j);
		        String valueType = value.getAttribute("type");

		        NodeList conditionList = value.getElementsByTagName("condition");
		        for (int k = 0; k < conditionList.getLength(); ++k)
		        {
		            Element condition = (Element) conditionList.item(k);
		            String conditionText = condition.getFirstChild().getNodeValue();
		            //System.out.println(conditionText);
		        }
		    }
		}
		
		System.out.println("Done");
	}
	
	
}
