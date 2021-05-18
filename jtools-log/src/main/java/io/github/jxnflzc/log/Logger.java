package io.github.jxnflzc.log;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @author jxnflzc
 * @date 2021/4/17
 */
public class Logger {
    private String name;

    private String consoleTemplate;

    private String fileTemplate;

    private String consoleTimeTemplate;

    private String fileTimeTemplate;

    private LogLevel minConsoleLogLevel;

    private LogLevel minFileLogLevel;

    private String logPath;

    private String logFile;

    private static final String DEFAULT_LOG_PATH = "log";

    private static final String DEFAULT_LOG_NAME = "log.log";

    private static final String DEFAULT_NAME = "LOGGER";

    private static final String DEFAULT_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss.SSS";

    private static final String DEFAULT_TEMPLATE = "%d [%t] %C.%M [%l] - %m";

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
                // Do nothing.
            }
        }

        // 获取日志本地保存路径及文件名
        generateLogLocal(properties);

        // 获取日志输出格式
        generatePattern(properties);

        // 获取日志输出级别
        generateLogLevel(properties);

        // 生成时间相关模板
        generateTimeTemplate();
    }

    private void generateLogLocal(Properties properties) {
        String logPath = properties.getProperty("jtools.log.file.path");
        String logFile = properties.getProperty("jtools.log.file.name");

        if (StringUtils.isBlank(logPath) && StringUtils.isBlank(logFile)) {
            return;
        }

        while (logPath.contains("{") && logPath.contains("}")) {
            String logPathTimeTemplate = getTimeTemplateFromResource(0, logPath);
            if (StringUtils.isNotBlank(logPathTimeTemplate)) {
                logPath = logPath.replace("{" + logPathTimeTemplate + "}", getNowDateTime(logPathTimeTemplate));
            }
        }
        this.logPath = StringUtils.isNotBlank(logPath) ? logPath : DEFAULT_LOG_PATH;
        while (logFile.contains("{") && logFile.contains("}")) {
            String logNameTimeTemplate = getTimeTemplateFromResource(0, logFile);
            if (StringUtils.isNotBlank(logNameTimeTemplate)) {
                logFile = logFile.replace("{" + logNameTimeTemplate + "}", getNowDateTime(logNameTimeTemplate));
            }
        }
        this.logFile = StringUtils.isNotBlank(logFile) ? logFile : DEFAULT_LOG_NAME;
    }

    private void generatePattern(Properties properties) {
        String consolePattern = properties.getProperty("jtools.log.console.pattern");
        this.consoleTemplate = consolePattern == null ? DEFAULT_TEMPLATE : consolePattern;

        String filePattern = properties.getProperty("jtools.log.file.pattern");
        this.fileTemplate = filePattern == null ? DEFAULT_TEMPLATE : filePattern;
    }

    private void generateLogLevel(Properties properties) {
        String consoleLevel = properties.getProperty("jtools.log.console.level");
        try {
            this.minConsoleLogLevel = generateLogLevel(consoleLevel);
        } catch (IllegalAccessException ex) {
            this.minConsoleLogLevel = LogLevel.DEBUG;
        }

        String fileLevel = properties.getProperty("jtools.log.file.level");
        try {
            this.minFileLogLevel = generateLogLevel(fileLevel);
        } catch (IllegalAccessException ex) {
            this.minFileLogLevel = LogLevel.DEBUG;
        }
    }

    private void generateTimeTemplate() {
        int timeIndex = consoleTemplate.indexOf("%d");
        String consoleTimeTemplate = getTimeTemplateFromResource(timeIndex, consoleTemplate);
        this.consoleTimeTemplate = consoleTimeTemplate == null ? DEFAULT_TIME_FORMAT : consoleTimeTemplate;
        this.consoleTemplate = this.consoleTemplate.replace("{" + this.consoleTimeTemplate + "}", "");

        timeIndex = fileTemplate.indexOf("%d");
        String fileTimeTemplate = getTimeTemplateFromResource(timeIndex, fileTemplate);
        this.fileTimeTemplate = fileTimeTemplate == null ? DEFAULT_TIME_FORMAT : fileTimeTemplate;
        this.fileTemplate = this.fileTemplate.replace("{" + this.fileTimeTemplate + "}", "");

        //移除多余空格
        this.consoleTimeTemplate = this.consoleTimeTemplate.trim();
        this.fileTimeTemplate = this.fileTimeTemplate.trim();
    }

    private LogLevel generateLogLevel(String level) throws IllegalAccessException {
        for (LogLevel logLevel : LogLevel.values()) {
            if (logLevel.toString().equals(level)) {
                return logLevel;
            }
        }
        throw new IllegalAccessException();
    }

    private String getTimeTemplateFromResource(int timeIndex, String pattern) {
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
        if (minConsoleLogLevel.compareTo(logLevel) > 0) {
            return;
        }

        for (Object arg : args) {
            content = content.replaceFirst("\\{}", arg.toString());
        }

        // 格式化输出内容
        String output = generateOutput(consoleTemplate, content, logLevel, consoleTimeTemplate);

        System.out.println(output);
    }

    private void writeLog(String content, LogLevel logLevel, Object ... args) {
        if (minFileLogLevel.compareTo(logLevel) > 0) {
            return;
        }

        if (StringUtils.isBlank(logPath) || StringUtils.isBlank(logFile)) {
            return;
        }

        for (Object arg : args) {
            content = content.replaceFirst("\\{}", arg.toString());
        }

        // 格式化输出内容
        String output = generateOutput(fileTemplate, content, logLevel, fileTimeTemplate);

        try {
            File tempFile = new File(logPath);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(logPath + File.separator + logFile, true));
            bw.write(output);
            bw.newLine();
            bw.close();
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }

    private String generateOutput(String template, String content, LogLevel logLevel, String timeTemplate) {
        String output = template;
        output = output.replace("%d", getNowDateTime(timeTemplate));
        output = output.replace("%l", String.format("%5s", logLevel));
        output = output.replace("%t", Thread.currentThread().getName());
        output = output.replace("%C", name);
        output = output.replace("%M", Thread.currentThread().getStackTrace()[4].getMethodName());
        output = output.replace("%F", Thread.currentThread().getStackTrace()[4].getFileName());
        output = output.replace("%L", String.valueOf(Thread.currentThread().getStackTrace()[4].getLineNumber()));
        output = output.replace("%m", content);
        return output;
    }

    public void debug(String content, Object ... args) {
        printLog(content, LogLevel.DEBUG, args);
        writeLog(content, LogLevel.DEBUG, args);
    }

    public void info(String content, Object ... args) {
        printLog(content, LogLevel.INFO, args);
        writeLog(content, LogLevel.INFO, args);
    }

    public void warn(String content, Object ... args) {
        printLog(content, LogLevel.WARN, args);
        writeLog(content, LogLevel.WARN, args);
    }

    public void error(String content, Object ... args) {
        printLog(content, LogLevel.ERROR, args);
        writeLog(content, LogLevel.ERROR, args);
    }

    public void fatal(String content, Object ... args) {
        printLog(content, LogLevel.FATAL, args);
        writeLog(content, LogLevel.FATAL, args);
    }

    public String getName() {
        return name;
    }

    enum LogLevel {
        DEBUG, INFO, WARN, ERROR, FATAL;
    }
}
