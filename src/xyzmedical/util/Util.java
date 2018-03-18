package xyzmedical.util;

import java.util.Date;

/**
 *
 * @author Will
 */
public class Util {
    public static Date jDate(String sqlDateStr) {
        String[] dateParts = sqlDateStr.split("-");
        Date utilDate = new Date(Integer.parseInt(dateParts[0]), 
                Integer.parseInt(dateParts[1]), 
                Integer.parseInt(dateParts[2]));
        return utilDate;
    }
    
    public static String sqlValue(Date date) {
        String dateStr = "";
        dateStr += String.valueOf(date.getYear()) + "-";
        dateStr += String.valueOf(date.getMonth()) + "-";
        dateStr += String.valueOf(date.getDay());
        return dateStr;
    }
    
    public static String sqlValue(String value) {
        return "'" + value + "'";
    }
    
    public static String sqlValue(int value) {
        return String.valueOf(value);
    }
    
    public static String sqlValue(double value) {
        return String.valueOf(value);
    }
}
