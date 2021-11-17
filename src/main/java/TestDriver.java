import java.util.Arrays;


public class TestDriver {

	public static void printer(Object ... myStrings) {
		
		for(Object s : myStrings) {
			System.out.println("String: " + s);
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Hello world");
		
		printer(100, 50.55, 'c', "hello", "world", "one", "two", "three", Arrays.asList("item1", "item2", "item3"));
		
	}

}
