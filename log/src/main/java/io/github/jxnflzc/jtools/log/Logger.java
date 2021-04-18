package io.github.jxnflzc.jtools.log;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Logger {
    private String name;

    private String template;

    private static final String DEFAULT_NAME = "LOGGER";

    private static final String OUTPUT = "%s%c\033[38m";

    private static final String DEFAULT_TEMPLATE = "%d [%l] %C.%M(%F:%L) - %m";

    protected Logger(Class<?> clazz) {
        if (null != clazz) {
            this.name = clazz.getName();
        } else {
            this.name = DEFAULT_NAME;
        }
        readProperties();
    }

    protected Logger(String name) {
        if (null != name) {
            this.name = name;
        } else {
            this.name = DEFAULT_NAME;
        }
        readProperties();
    }

    private String getNowDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        return sdf.format(new Date());
    }

    public void readProperties() {
        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("log.properties");
        if (resourceAsStream != null) {
            try {
                properties.load(resourceAsStream);
                resourceAsStream.close();
            } catch (IOException exception) {

            }
        }
        String pattern = properties.getProperty("pattern");
        this.template = pattern == null ? OUTPUT.replace("%c", DEFAULT_TEMPLATE) : pattern;
    }

    private void printLog(String content, LogLevel logLevel, Object ... args) {
        for (Object arg : args) {
            content = content.replaceFirst("\\{}", arg.toString());
        }

        // 格式化输出内容
        String output = template;
        output = output.replace("%d", getNowDateTime());
        output = output.replace("%l", String.format("%5s", logLevel));
        output = output.replace("%C", name);
        output = output.replace("%M", Thread.currentThread().getStackTrace()[3].getMethodName());
        output = output.replace("%F", Thread.currentThread().getStackTrace()[3].getFileName());
        output = output.replace("%L", String.valueOf(Thread.currentThread().getStackTrace()[3].getLineNumber()));
        output = output.replace("%m", content);

        String result = String.format(output, logLevel.getColor());
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
