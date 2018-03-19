package xyzmedical.db;

import java.sql.Date;
import java.sql.Timestamp;

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
    
    public static Timestamp jTimestamp(String sqlTimestampStr) {
        String[] tstampSplit = sqlTimestampStr.split(" ");
        String[] tstampDate = tstampSplit[0].split("-");
        String[] tstampTime = tstampSplit[1].split(":");
        
        int year = Integer.parseInt(tstampDate[0]);
        int month = Integer.parseInt(tstampDate[1]);
        int day = Integer.parseInt(tstampDate[2]);
        int hr = Integer.parseInt(tstampTime[0]);
        int min = Integer.parseInt(tstampTime[1]);
        int sec = Integer.parseInt(tstampTime[2]);
        int ns = 0;
        
        return new Timestamp(year, month, day, hr, min, sec, ns);
    }
    
    public static String sqlValue(Date date) {
        String dateStr = "";
        if (date != null) {
            dateStr += String.valueOf(date.getYear()) + "-";
            dateStr += String.valueOf(date.getMonth()) + "-";
            dateStr += String.valueOf(date.getDay());
        }
        return Util.sqlValue(dateStr);
    }
    
    public static String sqlValue(Timestamp timestamp) {
        String timeStr = "";
        if (timestamp != null) {
            timeStr += String.valueOf(timestamp.getYear()) + "-";
            timeStr += String.valueOf(timestamp.getMonth()) + "-";
            timeStr += String.valueOf(timestamp.getDay()) + " ";
            timeStr += String.valueOf(timestamp.getHours()) + ":";
            timeStr += String.valueOf(timestamp.getMinutes()) + ":";
            timeStr += String.valueOf(timestamp.getSeconds());
        }
        return Util.sqlValue(timeStr);
    }
    
    public static String sqlValue(String value) {
        if (value == null) {
            value = "";
        }
        return "'" + value + "'";
    }
    
    public static String sqlValue(int value) {
        return String.valueOf(value);
    }
    
    public static String sqlValue(double value) {
        return String.valueOf(value);
    }
    
    public static String sqlTableAttrib(String value) {
        if (value == null) {
            value = "";
        }
        return "`" + value + "`";
    }
}
