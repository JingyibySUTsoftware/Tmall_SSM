package com.Tmall.service.Impl;

import com.Tmall.bean.Category;
import com.Tmall.bean.Product;
import com.Tmall.bean.ProductImage;
import com.Tmall.mapper.ProductMapper;
import com.Tmall.service.OrderItemService;
import com.Tmall.service.ProductImageService;
import com.Tmall.service.ProductService;
import com.Tmall.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingyi
 * @Classname ProductServiceImpl
 * @description TODO
 * @date 2021/8/3 10:20
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductImageService productImageService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private ReviewService reviewService;
    @Override
    public List<Product> list(int start, int count, int cid) {
        return productMapper.list(start, count, cid);
    }

    @Override
    public void add(Product p) {
        productMapper.add(p);
    }


    @Override
    public Product get(int id) {
        return productMapper.get(id);
    }

    @Override
    public void update(Product p) {
        productMapper.update(p);
    }


    @Override
    public void delete(int id) {
        productMapper.delete(id);
    }

    @Override
    public void setFirstProductImage(Product p) {

    }


    @Override
    public int total(int cid) {
        return productMapper.total(cid);
    }

    @Override
    public List<Product> listBycid(Integer cid) {
        return productMapper.listBycid(cid);
    }
    @Override
    public void fill(List<Category> categoryList) {
        for (Category category : categoryList) {
            fill(category);
        }
    }
    //每一类所属的所有产品绑定
    @Override
    public void fill(Category c) {
        List<Product> productList = listBycid(c.getId());
        for (Product product : productList) {
            product.setProductImage(setforeFirstProductImage(product));
        }
        c.setProducts(productList);
    }
    //给每个产品添加封面图片属性
    public ProductImage setforeFirstProductImage(Product product) {
        ProductImage productImage = null;
        List<ProductImage> list = productImageService.list(product.getId(), ProductImageService.TYPE_SINGLE);
        if (!list.isEmpty()){
            productImage = list.get(0);
        }
        return  productImage;
    }
    //给首页菜单添加产品小标题，每行8个
    @Override
    public void fillByRow(List<Category> categoryList) {
        int productNumEachRow=8;
        for (Category category : categoryList) {
            List<Product> products = category.getProducts();
            for (Product product : products) {
                for (Product product1 : products) {
                    product1.setProductImage(setforeFirstProductImage(product1));
                }
            }
            List<List<Product>> productRow = new ArrayList<>();
            for(int i=0;i<products.size();i+=productNumEachRow){
                int size = i + productNumEachRow;
                size = size > products.size() ? products.size() : size;
                List<Product> temp = products.subList(i,size);
                productRow.add(temp);
            }
            category.setProductsRow(productRow);
        }
    }
    public void setSaleAndReviewNumber(Product p) {
        //为产品设置销售和评价数量
        int saleCount = orderItemService.getSaleCount(p.getId());
        p.setSaleCount(saleCount);

        int reviewCount = reviewService.getCount(p.getId());
        p.setReviewCount(reviewCount);

    }

    public void setSaleAndReviewNumber(List<Product> products) {
        for (Product p : products) {
            setSaleAndReviewNumber(p);
        }
    }

    @Override
    public List<Product> searchBykeyword(String keyword) {
        return productMapper.searchBykeyword(keyword);
    }
}
