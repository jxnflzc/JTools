package io.github.jxnflzc.util;

import io.github.jxnflzc.util.annotation.ClassInfo;
import io.github.jxnflzc.util.annotation.FieldInfo;
import io.github.jxnflzc.util.annotation.MethodInfo;
import io.github.jxnflzc.util.annotation.ParameterInfo;
import io.github.jxnflzc.util.entity.ClassEntity;
import io.github.jxnflzc.util.entity.FieldEntity;
import io.github.jxnflzc.util.entity.MethodEntity;
import io.github.jxnflzc.util.entity.ParameterEntity;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author jxnflzc
 * @version 1.0
 */
public class ClassInfoUtil {
    public static ClassEntity getClassEntity(Class<?> clazz) {
        ClassEntity ce = new ClassEntity();

        ClassInfo classInfo = clazz.getAnnotation(ClassInfo.class);
        if (null != classInfo) {
            ce.setName(StringUtils.isNotBlank(classInfo.name()) ? classInfo.name() : clazz.getSimpleName());
            ce.setDesc(classInfo.desc());

            generateField(clazz.getDeclaredFields(), ce);

            generateMethod(clazz.getDeclaredMethods(), ce);
        }

        return ce;
    }

    private static void generateField(Field[] fields, ClassEntity ce) {
        for (Field field: fields) {
            FieldInfo fieldInfo = field.getAnnotation(FieldInfo.class);
            if (null != fieldInfo) {
                FieldEntity fe = new FieldEntity();
                fe.setName(StringUtils.isNotBlank(fieldInfo.name()) ? fieldInfo.name() : field.getName());
                fe.setDesc(fieldInfo.desc());
                fe.setType(field.getType().getSimpleName());

                ce.addFieldEntity(fe);
            }
        }
    }

    private static void generateMethod(Method[] methods, ClassEntity ce) {
        for (Method method: methods) {
            MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
            if (null != methodInfo) {
                MethodEntity me = new MethodEntity();
                me.setName(StringUtils.isNotBlank(methodInfo.name()) ? methodInfo.name() : method.getName());
                me.setDesc(methodInfo.desc());
                me.setReturnType(method.getReturnType().getSimpleName());
                generateMethodParameter(method.getParameters(), me);

                ce.addMethodEntity(me);
            }
        }
    }

    private static void generateMethodParameter(Parameter[] parameters, MethodEntity me) {
        for (Parameter parameter: parameters) {
            ParameterInfo parameterInfo = parameter.getAnnotation(ParameterInfo.class);
            if (null != parameterInfo) {
                ParameterEntity pe = new ParameterEntity();
                pe.setName(StringUtils.isNotBlank(parameterInfo.name()) ? parameterInfo.name() : parameter.getName());
                pe.setDesc(parameterInfo.desc());
                pe.setType(parameter.getType().getSimpleName());

                me.addParameterEntity(pe);
            }
        }
    }
}
