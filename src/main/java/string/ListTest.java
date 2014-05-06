package string;

import java.util.Arrays;
import java.util.List;

public class ListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("A", "B", "C","D");
		
		System.out.println(strings.toString().substring(1, strings.toString().length()-1));
		
		for(String s : strings.toString().split(",")) {
			System.out.println(s);
		}
		
		
		System.out.println("\nSingle Split");
		for(String s : "A".split(",")) {
			System.out.println(s);
		}
	}

}
