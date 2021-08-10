package com.Tmall.bean;

/**
 * @author jingyi
 * @Classname Property
 * @description 属性实体类
 * @date 2021/8/3 9:31
 */
public class Property {
    private Integer id;
    private Integer cid;//类别ID
    private Category category;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
