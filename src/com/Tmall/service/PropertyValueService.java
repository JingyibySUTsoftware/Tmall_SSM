package com.Tmall.service;

import com.Tmall.bean.Product;
import com.Tmall.bean.PropertyValue;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface PropertyValueService {
    /**
     *
     * @Title: init
     * @Description: 初始化产品的相关属性值
     * @param @param p 参数
     * @return void 返回类型
     * @throws
     */
    void init(Product p);
    /**
     *
     * @Title: getPvByPid
     * @Description:通过产品的id获取产品的相关属性
     * @param @param pid
     * @param @return 参数
     * @return List<PropertyValue> 返回类型
     * @throws
     */
    List<PropertyValue> getPvByPid(Integer pid);
    /**
     *
     * @Title: updateVByid
     * @Description: 利用ajax后台异步更新产品属性值
     * @param @param id
     * @param @return 参数
     * @return int 返回类型
     * @throws
     */
    int updateVByid(PropertyValue p);
    /**
     *
     * @Title: getPv
     * @Description: 根据产品id和属性id获取属性值对象
     * @param @param pid
     * @param @param ptid
     * @param @return 参数
     * @return PropertyValue 返回类型
     * @throws
     */
    PropertyValue getPv(Integer pid,Integer ptid);
    /**
     *
     * @Title: addPv
     * @Description: 初始化使用，添加属性字段
     * @param @param pv 参数
     * @return void 返回类型
     * @throws
     */
    void addPv(PropertyValue pv);
}
