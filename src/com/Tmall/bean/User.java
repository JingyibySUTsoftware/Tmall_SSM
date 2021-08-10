package com.Tmall.bean;

/**
 * @author jingyi
 * @Classname User
 * @description 用户实体类
 * @date 2021/8/3 9:33
 */
public class User {
    private Integer id;
    private String name;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
