package string;

public class CSVTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] list = {"hello","world"};
		String[] list2 = {"hello"};
		String[] list3 = {""};
		String[] list4 = {"", null};
		
		
		System.out.println(convertToCSV(list));
		System.out.println(convertToCSV(list2));
		System.out.println(convertToCSV(list3));
		System.out.println(convertToCSV(list4));

	}

	
	private static String convertToCSV(String ... list) {
		
		StringBuilder sb = new StringBuilder();
		
		for(String s : list) {
			if(s != null && !"".equals(s)) {
				sb.append(s);
				sb.append(',');
			}			
		}

		if(sb.length() > 0) {
			sb.deleteCharAt(sb.length()-1);
		}
		
		return sb.toString();
	}
	
}
