package runtime;

/**
 * Created by Sun on 2015/12/10.
 */
public class GetAvailableProcessor {
    public static void main(String[] args) {
        int processors=Runtime.getRuntime().availableProcessors();
        System.out.println(processors);
    }
}
