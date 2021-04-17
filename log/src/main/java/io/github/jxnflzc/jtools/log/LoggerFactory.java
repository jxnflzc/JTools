package io.github.jxnflzc.jtools.log;

public class LoggerFactory {
    public static Logger getLogger(Class<?> clazz) {
        return new Logger(clazz);
    }

    public static Logger getLogger(String name) {
        return new Logger(name);
    }
}
