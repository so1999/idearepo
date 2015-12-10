package string;

/**
 * Created by Sun on 2015/12/10.
 */
public class StringFormatTest {
    public static void main(String[] args) {
        double input=32.123456;
        System.out.println("double: " +input);
        System.out.println("double: "+String.format("%.2f",input));
    }
}
