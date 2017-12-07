package core;

import java.util.Calendar;

public class Helpers {

    public static String getUniqueString(String prefix) {
        Calendar cal = Calendar.getInstance();
        return String.format(prefix + " %tF %<tT.%<tL", cal, cal);
    }
}
