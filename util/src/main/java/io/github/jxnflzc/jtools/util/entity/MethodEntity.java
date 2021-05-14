package io.github.jxnflzc.jtools.util.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
