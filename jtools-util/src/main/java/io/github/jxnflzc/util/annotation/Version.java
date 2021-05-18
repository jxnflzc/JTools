package io.github.jxnflzc.util.annotation;

import io.github.jxnflzc.util.handler.VersionHandler;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jxnflzc
 * @date 2021/5/13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Version {
    String prefix() default "v";

    String major() default "1";

    String minor() default "0";

    String build() default "0";

    boolean isSnapshot() default false;

    Class<? extends VersionHandler> versionHandler() default VersionHandler.class;
}
