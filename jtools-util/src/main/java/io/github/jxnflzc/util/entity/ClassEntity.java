package io.github.jxnflzc.util.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jxnflzc
 * @date 2021/5/13
 */
@Data
public class ClassEntity {
    private String name;

    private String desc;

    private List<FieldEntity> fields;

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
