package string;

public class CSVTester2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test = "hello";
		String test2 = "hello,world";
		String test3 = "hello, world , tester";
		String test4 = "";
		
		
		
		print(test);
		print(test2);
		print(test3);
		print(test4);
		
		

	}

	
	public static void print(String input) {
		for(String s : input.split(",")) {
			
			if(!"".equals(s.trim())) 
				System.out.printf("%s ", s.trim());
		}
		System.out.println("");
	}
	
	
}
