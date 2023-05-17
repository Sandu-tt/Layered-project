package lk.ijse.daycare.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtill {

    public static String timeNow() {
        SimpleDateFormat format =new SimpleDateFormat("hh:mm");
        return format.format(new Date());
    }
}
