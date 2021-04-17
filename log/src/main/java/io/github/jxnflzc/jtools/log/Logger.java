package io.github.jxnflzc.jtools.log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private String name;

    private static final String DEFAULT_NAME = "LOGGER";

    private static final String TEMPLATE = "%s%s [%5s] %s - %s\033[38m";

    protected Logger(Class<?> clazz) {
        if (null != clazz) {
            this.name = clazz.getName();
        } else {
            this.name = DEFAULT_NAME;
        }
    }

    protected Logger(String name) {
        if (null != name) {
            this.name = name;
        } else {
            this.name = DEFAULT_NAME;
        }
    }

    private String getNowDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        return sdf.format(new Date());
    }

    private void printLog(String content, LogLevel logLevel, Object ... args) {
        for (Object arg : args) {
            content = content.replaceFirst("\\{}", arg.toString());
        }
        String result = String.format(TEMPLATE, logLevel.getColor(), getNowDateTime(), logLevel, name, content);
        System.out.println(result);
    }

    public void debug(String content, Object ... args) {
        printLog(content, LogLevel.DEBUG, args);
    }

    public void info(String content, Object ... args) {
        printLog(content, LogLevel.INFO, args);
    }

    public void warn(String content, Object ... args) {
        printLog(content, LogLevel.WARN, args);
    }

    public void error(String content, Object ... args) {
        printLog(content, LogLevel.ERROR, args);
    }

    public void fatal(String content, Object ... args) {
        printLog(content, LogLevel.FATAL, args);
    }

    public String getName() {
        return name;
    }

    enum LogLevel {
        DEBUG("\033[37m"),
        INFO("\033[38m"),
        WARN("\033[33m"),
        ERROR("\033[31m"),
        FATAL("\033[1;31m");

        private final String color;

        LogLevel(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }
}
