package io.github.jxnflzc.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jxnflzc
 * date 2021/5/13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface MethodInfo {
    // Name of method
    String name() default "";

    // Description of method
    String desc() default "";
}
