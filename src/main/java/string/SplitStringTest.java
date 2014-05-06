package string;

public class SplitStringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "";
		
		for(String i : s.split(",")) {
			System.out.print(i);
			System.out.println("...");
		}
		
		System.out.print("done.");
	}

}
