
public class TryExceptionTester {

    public static void main(String[] args) {

        System.out.println("start");

        try {
            throw new RuntimeException("runtime");
        } catch(RuntimeException r) {
            System.out.println("caught r");
            throw r;
        } catch(Exception e) {
            System.out.println("caught e");
            e.printStackTrace();
        }
        System.out.println("done");
    }

}
