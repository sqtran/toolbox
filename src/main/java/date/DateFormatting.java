package date;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormatting {

    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        System.out.println(formatter.format(new Date()));
    }

}
