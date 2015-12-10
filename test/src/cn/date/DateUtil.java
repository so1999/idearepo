package cn.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sun on 2015/11/4.
 */
public class DateUtil {


    public static String format(String pattern, String datestr)
            throws ParseException {
        SimpleDateFormat simpleDateFormat = null;
        if (datestr == null)
            return "";
        if ("00000000".equals(datestr) || "0000-00-00".equals(datestr)) {
            if ("yyyyMMdd".equals(pattern)) {
                return "00000000";
            } else if ("yyyy-MM-dd".equals(pattern)) {
                return "0000-00-00";
            }
        }
        if (datestr.indexOf("-") > 0) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        } else {
            simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        }
        Date date = simpleDateFormat.parse(datestr);
        simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
}
