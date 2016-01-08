package runtime;

/**
 * Created by Sun on 2015/12/10.
 */
public class GetAvailableProcessor {
    public static void main(String[] args) {
        int processors=Runtime.getRuntime().availableProcessors();
        System.out.println(processors);

        String [] arr={"1","2","阿不错的风格密码"};
        String str=arr[2].substring(0,6);
        int ss=arr[2].length();
        System.out.println(ss);
    }
}
