package com.Tmall.service.Impl;

import com.Tmall.bean.Category;
import com.Tmall.mapper.CategoryMapper;
import com.Tmall.service.CategoryService;
import com.Tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jingyi
 * @Classname CategoryServiceImpl
 * @description TODO
 * @date 2021/8/3 10:18
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> list(Page page) {
        return categoryMapper.list(page);
    }
    @Override
    public int total() {
        return categoryMapper.total();
    }

    @Override
    public void add(Category c) {
        categoryMapper.add(c);
    }

    @Override
    public void delete(int id) {
        categoryMapper.delete(id);
    }

    @Override
    public Category get(int id) {
        return categoryMapper.get(id);
    }

    @Override
    public void update(Category c) {
        categoryMapper.update(c);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.getAllCategory();
    }


}
