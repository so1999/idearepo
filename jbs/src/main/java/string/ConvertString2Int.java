package string;

/**
 * Created by Sun on 2015/12/10.
 */
public class ConvertString2Int {
    public static void main(String[] args) {
        //1.parseInt returns a primitive int
        String number="10";
        int result=Integer.parseInt(number);
        System.out.println(result);

        //2.Integer.valueOf() returns an Integer object
        result=Integer.valueOf(number);
        System.out.println(result);


    }
}
