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
@Target(ElementType.FIELD)
@Documented
public @interface FieldInfo {
    /**
     * @return Name of field
     */
    String name() default "";

    /**
     * @return Description of field
     */
    String desc() default "";
}
