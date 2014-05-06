public class MatchesTest {

	public static void main(String[] args) {
		

		String sample = "<xml><field1>null</field1><field2>Something</field2><field3></field3></xml>";
		
		System.out.println(sample.contains("null|NULL"));
	}
}
