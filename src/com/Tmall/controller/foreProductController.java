package com.Tmall.controller;

import com.Tmall.bean.*;
import com.Tmall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author jingyi
 * @Classname foreProductController
 * @description TODO
 * @date 2021/8/15 15:26
 */
@Controller
public class foreProductController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ProductImageService productImageService;
    @Autowired
    private ProductService productService;
    @Autowired
    private PropertyValueService propertyValueService;
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("foreproduct")
    public String foreProduct(Integer id, Model model){
        Product product = productService.get(id);//产品信息
        Category category = categoryService.get(product.getCid());
        product.setCategory(category);
        productService.setSaleAndReviewNumber(product);//设置销量和评论数
        setFirstProductImage(product);
        List<ProductImage> pisSingle= productImageService.list(id, ProductImageService.TYPE_SINGLE);//缩略图
        List<ProductImage> pisDetail= productImageService.list(id, ProductImageService.TYPE_DETAIL);//商品详情页
        List<PropertyValue> pvlist = propertyValueService.getPvByPid(product.getId());
        List<Review> reviews = reviewService.getReviews(product.getId());
        model.addAttribute("product",product);
        model.addAttribute("pisSingle",pisSingle);
        model.addAttribute("pisDetail",pisDetail);
        model.addAttribute("pvlist",pvlist);
        model.addAttribute("reviews",reviews);
        model.addAttribute("SaleCount",product.getSaleCount());
        model.addAttribute("ReviewCount",product.getReviewCount());
        return "fore/product";
    }
    public void setFirstProductImage(Product product) {
        List<ProductImage> list = productImageService.list(product.getId(), ProductImageService.TYPE_SINGLE);
        if (!list.isEmpty()){
            ProductImage productImage = list.get(0);
            product.setProductImage(productImage);
        }
    }
}
