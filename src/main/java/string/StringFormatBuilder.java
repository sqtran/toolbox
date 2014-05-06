package string;


public class StringFormatBuilder {

    public static void main(String ... args) {
        
        int num = 11;
        
        String format = "----%" + num + "s----";
        
        System.out.println("format = " + format);
        
       System.out.println(String.format(format, "").replaceAll(" ", "-"));
    }
}
