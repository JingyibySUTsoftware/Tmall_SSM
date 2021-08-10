package com.Tmall.bean;

/**
 * @author jingyi
 * @Classname ProductImage
 * @description 产品图片实体类
 * @date 2021/8/3 9:12
 */
public class ProductImage {
    private Integer id;
    private Integer pid;//产品ID
    private String type;//图片类型
    private Product product;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
