<h1 align="center">Jtools</h1>

<p align="center">
    <a href="https://mvnrepository.com/artifact/io.github.jxnflzc"><img src="https://img.shields.io/maven-central/v/io.github.jxnflzc/jtools" alt="maven-central"></a>
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
        <groupId>io.github.jxnflzc</groupId>
        <artifactId>jtools-log</artifactId>
        <version>${jtools.version}</version>
    </dependency>
    ```

* log.properties配置文件

    ```properties
    # %d 日志打印时间，格式：yyyy/MM/dd HH:mm:ss.SSS
    # %t 当前线程
    # %l 日志级别
    # %C Java类名
    # %M Java方法名
    # %F Java文件名
    # %L 日志调用行数
    # %m 日志正文
    jtools.log.console.pattern = %d [%t] [%l] %C.%M(%F:%L) - %m
    jtools.log.file.pattern = %d [%t] [%l] %C.%M(%F:%L) - %m
    # 日志输出级别，具体如下
    # DEBUG
    # INFO
    # WARN
    # ERROR
    # FATAL
    jtools.log.console.level = DEBUG
    jtools.log.file.level = DEBUG
    # 日志输出到本地目录名，支持时间格式化
    jtools.log.file.path = {yyyy}/{MM}
    # 日志输出到本地文件名，支持时间格式化
    jtools.log.file.name = {MM-dd}.log
    ```

### pattern

* 设计模式工具包，包含部分设计模式接口及抽象类。

* Maven依赖

    ```xml
    <dependency>
        <groupId>io.github.jxnflzc</groupId>
        <artifactId>jtools-pattern</artifactId>
        <version>${jtools.version}</version>
    </dependency>
    ```
  
### util

* Util工具包，提供时间与类信息相关工具包。

* Maven依赖

    ```xml
    <dependency>
        <groupId>io.github.jxnflzc</groupId>
        <artifactId>jtools-util</artifactId>
        <version>${jtools.version}</version>
    </dependency>
    ```
