package io.github.jxnflzc.jtools.log;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Logger {
    private String name;

    private String template;

    private String timeTemplate;

    private static final String DEFAULT_NAME = "LOGGER";

    private static final String DEFAULT_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss.SSS";

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

    private String getNowDateTime(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
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
        this.template = pattern == null ? DEFAULT_TEMPLATE : pattern;

        String timeTemplate = getTimeTemplateFromResource(template);
        this.timeTemplate = timeTemplate == null ? DEFAULT_TIME_FORMAT : timeTemplate;
        this.template = this.template.replace("{" + this.timeTemplate + "}", "");

        //移除多余空格
        this.timeTemplate = this.timeTemplate.trim();
    }

    private String getTimeTemplateFromResource(String pattern) {
        int timeIndex = pattern.indexOf("%d");
        int from = -1, to = -1;
        for (; timeIndex < pattern.length(); timeIndex++) {
            if (pattern.charAt(timeIndex) == '{') {
                from = timeIndex + 1;
            }
            if (pattern.charAt(timeIndex) == '}') {
                to = timeIndex;
            }
        }

        if (from != -1 && to != -1 && to > from) {
            return pattern.substring(from, to);
        }
        return null;
    }

    private void printLog(String content, LogLevel logLevel, Object ... args) {
        for (Object arg : args) {
            content = content.replaceFirst("\\{}", arg.toString());
        }

        // 格式化输出内容
        String output = template;
        output = output.replace("%d", getNowDateTime(timeTemplate));
        output = output.replace("%l", String.format("%5s", logLevel));
        output = output.replace("%C", name);
        output = output.replace("%M", Thread.currentThread().getStackTrace()[3].getMethodName());
        output = output.replace("%F", Thread.currentThread().getStackTrace()[3].getFileName());
        output = output.replace("%L", String.valueOf(Thread.currentThread().getStackTrace()[3].getLineNumber()));
        output = output.replace("%m", content);

        System.out.println(output);
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
        DEBUG, INFO, WARN, ERROR, FATAL;
    }
}
