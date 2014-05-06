import java.net.InetAddress;


public class InetHelper {


	public static void main(String[] args) throws Exception {
		InetAddress inetAddr;

		 
		inetAddr = InetAddress.getByName("PTSHOST_SOAP");
		 
		System.out.println(inetAddr.getHostAddress());
	} 

}
