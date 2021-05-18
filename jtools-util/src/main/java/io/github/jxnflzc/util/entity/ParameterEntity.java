package io.github.jxnflzc.util.entity;

import lombok.Data;

/**
 * @author jxnflzc
 * @version 1.0
 */
@Data
public class ParameterEntity {
    /**
     * Name of parameter
     */
    private String name;

    /**
     * Description of parameter
     */
    private String desc;

    /**
     * Type of parameter
     */
    private String type;
}
