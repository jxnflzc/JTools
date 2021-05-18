package io.github.jxnflzc.log;

/**
 * Log output factory
 * @author jxnflzc
 * @version 1.0
 */
public class LoggerFactory {
    /**
     * Create log output class through class object
     * @param clazz Class object
     * @return Log output class
     */
    public static Logger getLogger(Class<?> clazz) {
        return new Logger(clazz);
    }

    /**
     * Create log output class by class name
     * @param name Class object
     * @return Log output class
     */
    public static Logger getLogger(String name) {
        return new Logger(name);
    }
}
