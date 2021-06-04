package io.github.jxnflzc.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jxnflzc
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Version {
    /**
     * @return Prefix of version
     */
    String prefix() default "v";

    /**
     * @return Major version of version
     */
    String major() default "1";

    /**
     * @return Minor version of version
     */
    String minor() default "0";

    /**
     * @return Build version of version
     */
    String build() default "0";

    /**
     * @return Is snapshot version or not
     */
    boolean isSnapshot() default false;

    /**
     * @return Authors of class
     */
    String[] authors() default {};
}
