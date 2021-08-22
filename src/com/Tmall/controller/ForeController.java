package com.Tmall.controller;

import com.Tmall.bean.Category;
import com.Tmall.comparator.*;
import com.Tmall.service.CategoryService;
import com.Tmall.service.ProductImageService;
import com.Tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

/**
 * @author jingyi
 * @Classname foreController
 * @description TODO
 * @date 2021/8/4 22:45
 */
@Controller
public class ForeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductImageService productImageService;
    @RequestMapping("forehome")
    public String Home(HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Category> categorylist = categoryService.getAllCategory();
        productService.fill(categorylist);
        productService.fillByRow(categorylist);
        session.setAttribute("categories",categorylist);
        return  "fore/home";
    }
    @RequestMapping("forecategory")
    public String showcategory(Integer cid, Model model,String sort){
        Category c = categoryService.get(cid);
        productService.fill(c);
        productService.setSaleAndReviewNumber(c.getProducts());
        if(sort!=null){
            switch (sort){
                case "review":
                    Collections.sort(c.getProducts(),new ProductReviewComparator());
                    break;
                case "date":
                    Collections.sort(c.getProducts(),new ProductDateComparator());
                    break;
                case "saleCount":
                    Collections.sort(c.getProducts(),new ProductSaleCountComparator());
                    break;
                case "price":
                    Collections.sort(c.getProducts(),new ProductPriceComparator());
                case "all":
                    Collections.sort(c.getProducts(),new ProductAllComparator());
                default:

            }
        }
        model.addAttribute("category",c);
        return "fore/category";
    }
}
