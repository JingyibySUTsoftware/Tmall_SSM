package com.Tmall.service;

import com.Tmall.bean.ProductImage;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface ProductImageService {
    public static final String TYPE_SINGLE="type_single";
    public static final String TYPE_DETAIL="type_detail";
    /**
     *
     * @Title: list
     * @Description: 查询所有产品图片
     * @param @param pid
     * @param @return 参数
     * @return List<ProductImage> 返回类型
     * @throws
     */
    List<ProductImage> list(int pid, String type);
    /**
     *
     * @Title: add
     * @Description: 添加商品图片
     * @param @param pi 参数
     * @return void 返回类型
     * @throws
     */
    void add(ProductImage pi);
    /**
     *
     * @Title: get
     * @Description: 根据id获取产品图片的信息
     * @param @param id 参数
     * @return void 返回类型
     * @throws
     */
    public ProductImage get(int id);
    /**
     *
     * @Title: delete
     * @Description: 根据id删除产品图片
     * @param @param id 参数
     * @return void 返回类型
     * @throws
     */
    public void delete(int id);
}
