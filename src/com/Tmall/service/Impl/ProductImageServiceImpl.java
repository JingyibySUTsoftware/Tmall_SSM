package com.Tmall.service.Impl;

import com.Tmall.bean.ProductImage;
import com.Tmall.mapper.ProductImageMapper;
import com.Tmall.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jingyi
 * @Classname ProductImageServiceImpl
 * @description TODO
 * @date 2021/8/3 10:19
 */
@Service
public class ProductImageServiceImpl implements ProductImageService{
    @Autowired
    private ProductImageMapper productImageMapper;
    @Override
    public List<ProductImage> list(int pid, String type) {
        return productImageMapper.list(pid,type);
    }

    @Override
    public void add(ProductImage pi) {
        productImageMapper.add(pi);
    }

    @Override
    public ProductImage get(int id) {
        return productImageMapper.get(id);
    }


    @Override
    public void delete(int id) {
        productImageMapper.delete(id);
    }

}
