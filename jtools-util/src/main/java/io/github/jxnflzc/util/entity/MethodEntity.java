package io.github.jxnflzc.util.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jxnflzc
 * @version 1.0
 */
@Data
public class MethodEntity {
    /**
     * Name of method
     */
    private String name;

    /**
     * Description of method
     */
    private String desc;

    /**
     * Return type of method
     */
    private String returnType;

    /**
     * Parameters of method
     */
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
