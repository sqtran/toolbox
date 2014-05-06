package string;

import java.util.Arrays;
import java.util.Collections;

public class ContainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		String rule = "3,5";
		String [] split = rule.replaceAll(" " , "").split(",");
		String test = "1,2,3,4,5";
		String[] split2 = test.replaceAll(" ", "").split(",");
		//System.out.println(!Collections.disjoint(Arrays.asList(split), Arrays.asList(split2)));

		System.out.println(contains(rule, test));		
	}
	
	public static boolean contains(String arg0,String arg1){
		 return !Collections.disjoint(Arrays.asList(arg0.replaceAll(" ", "").split(",")),Arrays.asList(arg1.replaceAll(" ", "").split(",")));
	}


}
