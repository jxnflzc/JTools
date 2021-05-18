package io.github.jxnflzc.util;

import lombok.SneakyThrows;

/**
 * @author jxnflzc
 * date 2021/5/18
 */
public class JtoolsBeanUtil {
    @SneakyThrows
    public static <E> E getBean(Class<E> clazz) {
        return clazz.newInstance();
    }
}
