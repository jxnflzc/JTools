package io.github.jxnflzc.log;

/**
 * @author jxnflzc
 * date 2021/4/17
 */
public class LoggerFactory {
    public static Logger getLogger(Class<?> clazz) {
        return new Logger(clazz);
    }

    public static Logger getLogger(String name) {
        return new Logger(name);
    }
}
