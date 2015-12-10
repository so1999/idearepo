package number;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Sun on 2015/12/10.
 */
public class DecimalFormatTest {
    private static DecimalFormat df2 = new DecimalFormat(".##");

    public static void main(String[] args) {
        double input = 32.123456;
        System.out.println("double: " + input);
        System.out.println("double: " + df2.format(input));

        df2.setRoundingMode(RoundingMode.UP);
        System.out.println("double(UP): " + df2.format(input));

        df2.setRoundingMode(RoundingMode.DOWN);
        System.out.println("double(DOWN): " + df2.format(input));
    }

}
