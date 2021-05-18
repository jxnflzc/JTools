package io.github.jxnflzc.util.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jxnflzc
 * @date 2021/5/13
 */
@Data
public class MethodEntity {
    private String name;

    private String desc;

    private String returnType;

    private List<ParameterEntity> parameters;

    public MethodEntity() {
        this.parameters = new ArrayList<>();
    }

    public void addParameterEntity(ParameterEntity parameterEntity) {
        if (null == this.parameters) {
            this.parameters = new ArrayList<>();
        }
        this.parameters.add(parameterEntity);
    }
}
