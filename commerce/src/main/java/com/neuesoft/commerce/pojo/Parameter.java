package com.neuesoft.commerce.pojo;

import org.springframework.stereotype.Component;

@Component
public class Parameter {

    /*参数管理实体类*/

    private int parameter_id;
    private String parameter_value;
    private String parameter_key;
    private String parameter_description;

    public Parameter() {
    }

    public Parameter(int parameter_id, String parameter_value, String parameter_key, String parameter_description) {
        this.parameter_id = parameter_id;
        this.parameter_value = parameter_value;
        this.parameter_key = parameter_key;
        this.parameter_description = parameter_description;
    }

    public int getParameter_id() {
        return parameter_id;
    }

    public void setParameter_id(int parameter_id) {
        this.parameter_id = parameter_id;
    }

    public String getParameter_value() {
        return parameter_value;
    }

    public void setParameter_value(String parameter_value) {
        this.parameter_value = parameter_value;
    }

    public String getParameter_key() {
        return parameter_key;
    }

    public void setParameter_key(String parameter_key) {
        this.parameter_key = parameter_key;
    }

    public String getParameter_description() {
        return parameter_description;
    }

    public void setParameter_description(String parameter_description) {
        this.parameter_description = parameter_description;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "parameter_id=" + parameter_id +
                ", parameter_value='" + parameter_value + '\'' +
                ", parameter_key='" + parameter_key + '\'' +
                ", parameter_description='" + parameter_description + '\'' +
                '}';
    }
}
