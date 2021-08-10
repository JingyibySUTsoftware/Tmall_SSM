package com.Tmall.controller;

import com.Tmall.bean.Category;
import com.Tmall.service.CategoryService;
import com.Tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @RequestMapping("forehome")
    public String Home(HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Category> categorylist = categoryService.getAllCategory();
        productService.fill(categorylist);
        productService.fillByRow(categorylist);
        session.setAttribute("categories",categorylist);
        return  "fore/home";
    }
}
