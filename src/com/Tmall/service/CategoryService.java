package com.Tmall.service;

import com.Tmall.bean.Category;
import com.Tmall.util.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CategoryService {
    /**
     * @param page
     *
     * @Title: list
     * @Description: 查询所有分类
     * @param @param page
     * @param @return 参数
     * @return List<Category> 返回类型
     * @throws
     */
    List<Category> list(Page page);
    /**
     *
     * @Title: total
     * @Description:查询类别总条数(也可以直接使用pagehelper插件的方法直接获取)
     * @param @return 参数
     * @return int 返回类型
     * @throws
     */
    int total();
    /**
     *
     * @Title: add
     * @Description:添加新的分类
     * @param @param c 参数
     * @return void 返回类型
     * @throws
     */
    void add(Category c);
    /**
     *
     * @Title: delete
     * @Description:删除某个分类
     * @param @param id 参数
     * @return void 返回类型
     * @throws
     */
    void delete(int id);
    /**
     *
     * @Title: get
     * @Description: 通过id查询该分类信息用于编辑
     * @param @param id
     * @param @return 参数
     * @return Category 返回类型
     * @throws
     */
    Category get(int id);
    /**
     *
     * @Title: update
     * @Description: 修改分类信息
     * @param @param c 参数
     * @return void 返回类型
     * @throws
     */
    void update(Category c);
    /*
     * @description 不分页获取分类信息
     * @author jingyi
     * @date 2021/8/4 22:58
     * @return java.util.List<com.Tmall.bean.Category>
     */
    List<Category> getAllCategory();
}

