package string;

public class EndsWith {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String match = "helloworld.png";
		
		System.out.println(match.endsWith(".PNG"));
		System.out.println(match.endsWith(".png"));
		System.out.println(match.endsWith(".Png"));
		
	}

}
