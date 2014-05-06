package string;

import java.util.ArrayList;

public class StringFormatPattern {

	public static void main (String ... args) {

		System.out.println(String.format("%10s %10s %10s", "hello", "world", "hello world steve"));

		ArrayList list = new ArrayList();
		list.add("hello");
		list.add("world");
		list.add("hello");
		
		System.out.println("hello".contains("hell"));
		System.out.println("hell".contains("hello"));
						
		System.out.println((Object) list);
		System.out.println(list);
		System.out.println(list.toString());
	}
}