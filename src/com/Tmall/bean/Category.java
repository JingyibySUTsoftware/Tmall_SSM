package com.Tmall.bean;

import java.util.List;

/**
 * @author jingyi
 * @Classname Category
 * @description 商品分类信息实体类
 * @date 2021/8/3 8:59
 */
public class Category {
    private Integer id;//分类ID
    private String name;//类别名
    //首页获取所有分类的商品
    private List<Product> products;
    //鼠标移到分类项上时，右侧展示商品链接
    private List<List<Product>> productsRow;


    public Integer getId() {        return id;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<List<Product>> getProductsRow() {
        return productsRow;
    }

    public void setProductsRow(List<List<Product>> productsRow) {
        this.productsRow = productsRow;
    }
}
