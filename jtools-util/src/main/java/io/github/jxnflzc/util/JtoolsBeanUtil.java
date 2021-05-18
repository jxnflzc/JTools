package io.github.jxnflzc.util;

import lombok.SneakyThrows;

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
}
