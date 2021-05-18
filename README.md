<h1 align="center">Jtools</h1>

<p align="center">
    <a href="https://mvnrepository.com/artifact/io.github.jxnflzc"><img src="https://img.shields.io/maven-central/v/io.github.jxnflzc/jtools" alt="maven-central"></a>
    <a href="https://www.oracle.com/technetwork/java/javase/downloads/index.html"><img src="https://img.shields.io/badge/JDK-8+-brightgreen.svg" alt="jdk 8+"></a>
    <a href="./LICENSE"><img src="https://img.shields.io/badge/license-Apache%202-orange" alt="license Apache 2.0"></a>
</p>

<h1 align="center">Module</h1>

### core

* <a href="https://mvnrepository.com/artifact/io.github.jxnflzc/jtools-core"><img src="https://img.shields.io/maven-central/v/io.github.jxnflzc/jtools-core" alt="jtools-core"></a>

* Contains all the following kits.

* Maven Dependency

    ```xml
    <dependency>
        <groupId>io.github.jxnflzc</groupId>
        <artifactId>jtools-core</artifactId>
        <version>${jtools.core.version}</version>
    </dependency>
    ```


### log

* <a href="https://mvnrepository.com/artifact/io.github.jxnflzc/jtools-log"><img src="https://img.shields.io/maven-central/v/io.github.jxnflzc/jtools-log" alt="jtools-log"></a>

* The log toolkit can be used for simple log output.

* The log is divided into 5 levels:`DEBUG`，`INFO`，`WARN`，`ERROR`，`FATAL`

* Maven Dependency

    ```xml
    <dependency>
        <groupId>io.github.jxnflzc</groupId>
        <artifactId>jtools-log</artifactId>
        <version>${jtools.log.version}</version>
    </dependency>
    ```

* log.properties configuration file

    ```properties
    # %d Log printing time, format:yyyy/MM/dd HH:mm:ss.SSS
    # %t Current thread
    # %l Log level
    # %C Java class name
    # %M Java method name
    # %F Java file name
    # %L Number of log call lines
    # %m Log body
    jtools.log.console.pattern = %d [%t] [%l] %C.%M(%F:%L) - %m
    jtools.log.file.pattern = %d [%t] [%l] %C.%M(%F:%L) - %m
    # Log output level, as follows
    # DEBUG
    # INFO
    # WARN
    # ERROR
    # FATAL
    jtools.log.console.level = DEBUG
    jtools.log.file.level = DEBUG
    # Log output to the local directory name, support time formatting
    jtools.log.file.path = {yyyy}/{MM}
    # Log output to local file name, support time formatting
    jtools.log.file.name = {MM-dd}.log
    ```

### pattern

* <a href="https://mvnrepository.com/artifact/io.github.jxnflzc/jtools-pattern"><img src="https://img.shields.io/maven-central/v/io.github.jxnflzc/jtools-pattern" alt="jtools-pattern"></a>

* Design pattern toolkit, including some design pattern interfaces and abstract classes.

* Maven Dependency

    ```xml
    <dependency>
        <groupId>io.github.jxnflzc</groupId>
        <artifactId>jtools-pattern</artifactId>
        <version>${jtools.pattern.version}</version>
    </dependency>
    ```
  
### util

* <a href="https://mvnrepository.com/artifact/io.github.jxnflzc/jtools-util"><img src="https://img.shields.io/maven-central/v/io.github.jxnflzc/jtools-util" alt="jtools-util"></a>

* Util toolkit, provides toolkits related to time and class information.

* Maven Dependency

    ```xml
    <dependency>
        <groupId>io.github.jxnflzc</groupId>
        <artifactId>jtools-util</artifactId>
        <version>${jtools.util.version}</version>
    </dependency>
    ```
