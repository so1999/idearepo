package cn.common.util;

import com.google.gson.Gson;

/**
 * Created by Sun on 2015/11/20.
 */
public class StringUtil {
    public static String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }
}
