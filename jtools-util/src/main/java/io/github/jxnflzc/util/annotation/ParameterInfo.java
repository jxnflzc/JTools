package io.github.jxnflzc.util.annotation;

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
@Target(ElementType.PARAMETER)
@Documented
public @interface ParameterInfo {
    // Name of parameter
    String name() default "";

    // Description of parameter
    String desc() default "";
}
