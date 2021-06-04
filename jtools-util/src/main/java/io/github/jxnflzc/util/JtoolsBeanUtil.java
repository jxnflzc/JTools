package io.github.jxnflzc.util;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author jxnflzc
 * @version 1.0
 */
public class JtoolsBeanUtil {
    /**
     * Get bean through class object
     * @param clazz Class object
     * @param <E> Type of class
     * @return Bean
     */
    @SneakyThrows
    public static <E> E getBean(Class<E> clazz) {
        return clazz.newInstance();
    }

    /**
     * Copy properties of source to target
     * @param source Source object
     * @param target Target object
     */
    @SneakyThrows
    public static void copyProperties(Object source, Object target) {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();
        Field[] targetFields = targetClass.getDeclaredFields();

        for (Field field: targetFields) {
            String getSourceMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1).toLowerCase();
            String setSourceMethodName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1).toLowerCase();
            Method getSourceMethod = sourceClass.getMethod(getSourceMethodName);
            Method setTargetMethod = targetClass.getMethod(setSourceMethodName, field.getType());
            setTargetMethod.invoke(target, getSourceMethod.invoke(source));
        }
    }
}
