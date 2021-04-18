<h1 align="center">Jtools</h1>

<p align="center">
    <a href="https://mvnrepository.com/search?q=io.github.jxnflzc.jtools"><img src="https://img.shields.io/maven-central/v/io.github.jxnflzc.jtools/jtools" alt="maven-central"></a>
    <a href="https://www.oracle.com/technetwork/java/javase/downloads/index.html"><img src="https://img.shields.io/badge/JDK-8+-brightgreen.svg" alt="jdk 8+"></a>
    <a href="./LICENSE"><img src="https://img.shields.io/badge/license-Apache%202-orange" alt="license Apache 2.0"></a>
</p>

<h1 align="center">Module</h1>

### log

* 日志工具包，可用于简单的日志输出。

* 日志分为5个等级：`DEBUG`，`INFO`，`WARN`，`ERROR`，`FATAL`
  
* Maven依赖

    ```xml
    <dependency>
        <groupId>io.github.jxnflzc.jtools</groupId>
        <artifactId>log</artifactId>
        <version>${jtools.version}</version>
    </dependency>
    ```

* log.properties配置文件

    ```properties
    # %d 日志打印时间，格式：yyyy/MM/dd HH:mm:ss.SSS
    # %l 日志级别
    # %C Java类名
    # %M Java方法名
    # %F Java文件名
    # %L 日志调用行数
    # %m 日志正文
    jtools.log.pattern = %d [%l] %C.%M(%F:%L) - %m
    # 日志输出级别，具体如下
    # DEBUG
    # INFO
    # WARN
    # ERROR
    # FATAL
    jtools.log.level = DEBUG
    ```
