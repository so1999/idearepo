package datetime;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Sun on 2015/12/10.
 */
public class TimeZonesTest {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        String dateInString="2015-12-10 10:15:55 上午";
        Date date =formatter.parse(dateInString);
        TimeZone tz=TimeZone.getDefault();

        //From TimeZone Asia/Shanghai
        System.out.println("TimeZone: "+tz.getID()+"-"+tz.getDisplayName());
        System.out.println("TimeZone: "+tz);
        System.out.println("Date: "+formatter.format(date));

        //To TimeZone America/New_York
        SimpleDateFormat sdfAmerica=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
        TimeZone tzInAmerica=TimeZone.getTimeZone("America/New_York");
        sdfAmerica.setTimeZone(tzInAmerica);

        String sDateInAmerica=sdfAmerica.format(date);
        Date dateInAmerica=sdfAmerica.parse(sDateInAmerica);

        System.out.println("\nTimeZone: " +tzInAmerica.getID()+"-" + tzInAmerica.getDisplayName());
        System.out.println("TimeZone: " +tzInAmerica);
        System.out.println("Date(String): "+sDateInAmerica);
        System.out.println("Date(Object): "+sdfAmerica.format(dateInAmerica));
    }
}
