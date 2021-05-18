package io.github.jxnflzc.util.entity;

import lombok.Data;

/**
 * @author jxnflzc
 * @version 1.0
 */
@Data
public class FieldEntity {
    /**
     * Name of field
     */
    private String name;

    /**
     * Description of field
     */
    private String desc;

    /**
     * Type of field
     */
    private String type;
}
