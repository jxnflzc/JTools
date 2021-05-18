package io.github.jxnflzc.util;

import lombok.SneakyThrows;

/**
 * @author jxnflzc
 * @version 1.0
 */
public class JtoolsBeanUtil {
    @SneakyThrows
    public static <E> E getBean(Class<E> clazz) {
        return clazz.newInstance();
    }
}
