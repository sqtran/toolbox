package string;

public class StringFormatter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long time = Long.MAX_VALUE - System.currentTimeMillis();

		System.out.println(String.format("%1$016X", time-5000));
		System.out.println(String.format("%1$016X", time-3000));
		System.out.println(String.format("%1$016X", time-1000));
		System.out.println(String.format("%1$016X", time+1000));
		System.out.println(String.format("%1$016X", time+3000));
		System.out.println(String.format("%1$016X", time+5000));
		
	}

}
