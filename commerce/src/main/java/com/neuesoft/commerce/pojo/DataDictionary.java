package com.neuesoft.commerce.pojo;

import org.springframework.stereotype.Component;

@Component
public class DataDictionary {

    private int dictionary_id;
    private String dictionary_type;
    private String dictionary_description;
    private int code;
    private String code_value;

    public DataDictionary() {
    }

    public DataDictionary(int dictionary_id, String dictionary_type, String dictionary_description, int code, String code_value) {
        this.dictionary_id = dictionary_id;
        this.dictionary_type = dictionary_type;
        this.dictionary_description = dictionary_description;
        this.code = code;
        this.code_value = code_value;
    }

    public int getDictionary_id() {
        return dictionary_id;
    }

    public void setDictionary_id(int dictionary_id) {
        this.dictionary_id = dictionary_id;
    }

    public String getDictionary_type() {
        return dictionary_type;
    }

    public void setDictionary_type(String dictionary_type) {
        this.dictionary_type = dictionary_type;
    }

    public String getDictionary_description() {
        return dictionary_description;
    }

    public void setDictionary_description(String dictionary_description) {
        this.dictionary_description = dictionary_description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCode_value() {
        return code_value;
    }

    public void setCode_value(String code_value) {
        this.code_value = code_value;
    }

    @Override
    public String toString() {
        return "DataDictionary{" +
                "dictionary_id=" + dictionary_id +
                ", dictionary_type='" + dictionary_type + '\'' +
                ", dictionary_description='" + dictionary_description + '\'' +
                ", code=" + code +
                ", code_value='" + code_value + '\'' +
                '}';
    }
}
