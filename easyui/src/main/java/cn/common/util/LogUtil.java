package cn.common.util;

import org.apache.log4j.Logger;

import java.util.Objects;

/**
 * Created by Sun on 2015/11/19.
 */
public class LogUtil {
    private static Logger logger = Logger.getLogger(LogUtil.class.getName());

    public static void debug(String msg) {
        logger.debug(msg);
    }

    public static void info(String msg) {
        logger.info(msg);
    }

    public static void error(String msg) {
        logger.error(msg);
    }
}
