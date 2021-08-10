package com.Tmall.service;

import com.Tmall.bean.Category;
import com.Tmall.bean.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface ProductService {
    /**
     *
     * @Title: list
     * @Description: 查询所有产品信息
     * @param @param start
     * @param @param count
     * @param @param cid
     * @param @return 参数
     * @return List<Product> 返回类型
     * @throws
     */
    List<Product> list(int start, int count, int cid);
    /**
     *
     * @Title: add
     * @Description:添加新产品
     * @param @param p 参数
     * @return void 返回类型
     * @throws
     */
    void add(Product p);
    /**
     *
     * @Title: get
     * @Description: 通过id查找产品信息，用于编辑
     * @param @param id
     * @param @return 参数
     * @return Product 返回类型
     * @throws
     */
    Product get(int id);
    /**
     *
     * @Title: update
     * @Description: 修改产品信息
     * @param @param p 参数
     * @return void 返回类型
     * @throws
     */
    void update(Product p);
    /**
     *
     * @Title: delete
     * @Description:删除某个产品信息
     * @param @param id 参数
     * @return void 返回类型
     * @throws
     */
    void delete(int id);
    /**
     *
     * @Title: setFirstProductImage
     * @Description: 设置产品页预览小图
     * @param @param p 参数
     * @return void 返回类型
     * @throws
     */
    void setFirstProductImage(Product p);
    /**
     * @Title: total
     * @Description: 通过商品类型id获取商品记录的总数
     * @param @param cid
     * @param @return 参数
     * @return int 返回类型
     * @throws
     */
    int total(int cid);
    /**
     * @description 查询所有商品不分页(用于给首页填充数据)
     * @param cid
     * @author jingyi
     * @date 2021/8/4 20:31
     * @return java.util.List<com.Tmall.bean.Product>
     */
    List<Product> listBycid(Integer cid);
    /*
     * @description 为每个分类填充产品集合
     * @param categoryList
     * @author jingyi
     * @date 2021/8/4 20:14
     * @return void
     */
    void fill(List<Category> categoryList);
    /*
     * @description 为每个分类填充产品集合
     * @param c
     * @author jingyi
     * @date 2021/8/4 20:15
     * @return void
     */
    void fill(Category c);
    /*
     * @description 为每行分类填充产品
     * @param categoryList
     * @author jingyi
     * @date 2021/8/4 20:17
     * @return void
     */
    void fillByRow(List<Category> categoryList);
}
