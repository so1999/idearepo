package string;

import java.util.Locale;

/**
 * Created by Sun on 2015/12/10.
 */
public class ConvertString2Enum {
    public static void main(String[] args) {

        System.out.println(WhoisRIR.valueOf("arin".toUpperCase(Locale.CHINESE)));

        WhoisRIR rir=WhoisRIR.valueOf("ripe".toUpperCase(Locale.ENGLISH));
        System.out.println(rir.getUrl());
    }
}
