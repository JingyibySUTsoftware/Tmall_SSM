package com.Tmall.bean;

/**
 * @author jingyi
 * @Classname 属性值实体类
 * @description TODO
 * @date 2021/8/3 9:32
 */
public class PropertyValue {
    private Integer id;
    private Integer pid;
    private Integer ptid;
    private String  value;
    private Property property;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPtid() {
        return ptid;
    }

    public void setPtid(Integer ptid) {
        this.ptid = ptid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
