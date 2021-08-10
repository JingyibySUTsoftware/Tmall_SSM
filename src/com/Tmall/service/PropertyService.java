package com.Tmall.service;

import com.Tmall.bean.Property;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface PropertyService {
    /**
     *
     * @Title: list
     * @Description: 查询所有属性
     * @param @param start
     * @param @param count
     * @param @param cid
     * @param @return 参数
     * @return List<Property> 返回类型
     * @throws
     */
    List<Property> list(int start , int count, int cid);
    /**
     *
     * @Title: add
     * @Description: 添加新的属性
     * @param @param p 参数
     * @return void 返回类型
     * @throws
     */
    void add(Property p);
    /**
     *
     * @Title: get
     * @Description:通过id查询该属性信息，用于编辑
     * @param @param id
     * @param @return 参数
     * @return Property 返回类型
     * @throws
     */
    Property get(int id);
    /**
     *
     * @Title: update
     * @Description: 修改某属性
     * @param @param p 参数
     * @return void 返回类型
     * @throws
     */
    void update(Property p);
    /**
     *
     * @Title: delete
     * @Description: 删除某属性
     * @param @param id 参数
     * @return void 返回类型
     * @throws
     */
    void delete(int id);
    /**
     * @Title: total
     * @Description: 根据商品类型id获取所有商品的属性数量
     * @param @param cid
     * @param @return 参数
     * @return int 返回类型
     * @throws
     */
    int total(int cid);
    /**
     *
     * @Title: listBycid
     * @Description: 根据商品类别获取这一类商品的属性集合
     * @param @param cid
     * @param @return 参数
     * @return List<Property> 返回类型
     * @throws
     */
    public List<Property> listBycid(Integer cid);
}
