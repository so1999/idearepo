package datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Sun on 2016/1/6.
 */
public class MonthCmp {
    public static void main(String[] args) throws ParseException {

        String dateStr1="2015-01-01";
        String dateStr2="2015-12-12";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar zz = Calendar.getInstance();
        Calendar ks = Calendar.getInstance();
        zz.setTime(sdf.parse(dateStr2));
        ks.setTime(sdf.parse(dateStr1));
        if(sdf.parse(dateStr2).getTime()>sdf.parse(dateStr1).getTime()) {
            int rs = zz.get(Calendar.MONTH) - ks.get(Calendar.MONTH);
            int month = (zz.get(Calendar.YEAR) - ks.get(Calendar.YEAR)) * 12;
            System.out.println(rs + month);
        }
    }
}

