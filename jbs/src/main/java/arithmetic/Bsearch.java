package arithmetic;

/**
 * Created by Sun on 2016/1/7.
 */
public class Bsearch {
    public static void main(String[] args) {
        int a[] = {20, 19, 90, 80, 12, 100, 290, 43,122};
        int k = 43;
        int l = 0;
        int h = a.length;
        while (h >= l) {
            int m = (l + h) / 2;
            if (a[m] == k) {
                System.out.println(m);
            } else if (a[m] > k) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
    }
}
