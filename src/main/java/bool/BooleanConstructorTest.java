package bool;

public class BooleanConstructorTest {

    public static void main(String[] args) {
        
        String t = "TRue ";
        t = null;
        Boolean b = null;
        
        String n = null;
        
        System.out.println("true");
        System.out.println("false");
        System.out.println("true ");
        System.out.println(t);
        System.out.println(new Boolean(null));
        System.out.println(new Boolean(n));



        System.out.println(new Boolean(b));
    }
}