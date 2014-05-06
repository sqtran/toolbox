package src.constructor;

public class SubConstructor extends Constructors  {

	
	public void printValue() {
		System.out.println("Value = " + value);
	}
	
	
	public static void main (String ... args) {
		
		SubConstructor sc = new SubConstructor();
		
		sc.printValue();
	}
	
}
