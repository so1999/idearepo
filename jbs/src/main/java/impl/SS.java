package impl;

/**
 * Created by Sun on 2016/1/7.
 */
public class SS {
    private static SS ourInstance = new SS();

    public static SS getInstance() {
        return ourInstance;
    }

    private SS() {
    }
}
