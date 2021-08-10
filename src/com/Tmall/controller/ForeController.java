package com.Tmall.controller;

import com.Tmall.bean.Category;
import com.Tmall.service.CategoryService;
import com.Tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author jingyi
 * @Classname foreController
 * @description TODO
 * @date 2021/8/4 22:45
 */
@Controller("foreController")
public class ForeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @RequestMapping("forehome")
    public String Home(Model model){
        List<Category> categorylist = categoryService.getAllCategory();
        productService.fill(categorylist);
        productService.fillByRow(categorylist);
        model.addAttribute("categories",categorylist);
        return  "fore/home";
    }
}
