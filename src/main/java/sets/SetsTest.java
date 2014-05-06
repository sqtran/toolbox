package sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Set<String> testSet = new HashSet<String>();
		 
		 testSet.addAll(Arrays.asList("A", "B","C","D","E"));
		 
		 
		 System.out.println(testSet);
		 
		 new HashSet<String>(Arrays.asList("A", "B","C","D","E"));
		 
	}
}
