package string;

public class StringReplaceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String test = "hello{world}";
		
		System.out.println(test.replaceAll("\\{world\\}", " steve"));
		//System.out.println(test.replaceAll("\\{world\\}", null));
		
		
		regExReplace();
	}
	
	public static void regExReplace() {
		
		
		String s = "org.apache.cxf.message.Message.PROTOCOL_HEADERS : {accept-encoding=[gzip,deflate], connection=[Keep-Alive], Content-Length=[301], content-type=[text/xml;charset=UTF-8], host=[localhost:8080], SOAPAction=[\"\"], user-agent=[Apache-HttpClient/4.1.1 (java 1.5)]}";
		

		System.out.println(s.replaceAll(", ", "\n"));

		
	}

}
