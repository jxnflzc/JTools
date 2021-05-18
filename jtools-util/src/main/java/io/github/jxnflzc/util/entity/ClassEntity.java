package io.github.jxnflzc.util.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jxnflzc
 * @version 1.0
 */
@Data
public class ClassEntity {
    /**
     * Name of class
     */
    private String name;

    /**
     * Description of class
     */
    private String desc;

    /**
     * Fields of class
     */
    private List<FieldEntity> fields;

    /**
     * Methods of class
     */
    private List<MethodEntity> methods;

    public ClassEntity() {
        this.fields = new ArrayList<>();
        this.methods = new ArrayList<>();
    }

    public void addFieldEntity(FieldEntity fieldEntity) {
        if (null == this.fields) {
            this.fields = new ArrayList<>();
        }
        this.fields.add(fieldEntity);
    }

    public void addMethodEntity(MethodEntity methodEntity) {
        if (null == this.methods) {
            this.methods = new ArrayList<>();
        }
        this.methods.add(methodEntity);
    }
}
