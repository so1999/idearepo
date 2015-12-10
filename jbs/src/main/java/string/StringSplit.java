package string;

import java.util.StringTokenizer;

/**
 * Created by Sun on 2015/12/10.
 */
public class StringSplit {
    public static void main(String[] args) {
        String phone = "012-3456789";
        String[] output = phone.split("-");
        System.out.println(output[0]);
        System.out.println(output[1]);

        String test = "abc.def.123";

        if (test.contains(".")) {
            output = test.split("\\.");
            if (output.length != 3) {
                throw new IllegalArgumentException(test + "-invalid format!");
            } else {
                System.out.println(output[0]);
                System.out.println(output[1]);
                System.out.println(output[2]);
            }
        }else {
            throw new IllegalArgumentException(test + "-invalid format!");
        }

        //StringTokenizer is avaliable since JDK 1.0
        StringTokenizer token=new StringTokenizer(test,".");
        while (token.hasMoreTokens()){
            System.out.println("StringTokenizer: "+token.nextToken());
        }


    }


}
