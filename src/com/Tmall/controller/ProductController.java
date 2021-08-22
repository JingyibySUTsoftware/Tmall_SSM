package com.Tmall.controller;

import com.Tmall.bean.Category;
import com.Tmall.bean.Product;
import com.Tmall.bean.ProductImage;
import com.Tmall.comparator.*;
import com.Tmall.service.CategoryService;
import com.Tmall.service.ProductImageService;
import com.Tmall.service.ProductService;
import com.Tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author jingyi
 * @Classname ProductController
 * @description TODO
 * @date 2021/8/3 10:29
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductImageService productImageService;
    @RequestMapping("admin_product_list")
    public String listProduct(int cid, Model model, Page page) {
        Category category = categoryService.get(cid);
        List<Product> pslist = productService.list(page.getStart(),page.getCount(),cid);
        setFirstProductImage(pslist);
        int total=productService.total(cid);
        page.setTotal(total);
        page.setParam("&cid="+category.getId());
        model.addAttribute("ps", pslist);
        model.addAttribute("c", category);
        model.addAttribute("page", page);
        return "admin/listProduct";
    }
    public void setFirstProductImage(Product product) {
        List<ProductImage> list = productImageService.list(product.getId(), ProductImageService.TYPE_SINGLE);
        if (!list.isEmpty()){
            ProductImage productImage = list.get(0);
            product.setProductImage(productImage);
        }
    }
    public void setFirstProductImage(List<Product> products){
        for (Product product : products){
            setFirstProductImage(product);
        }
    }


    @RequestMapping("admin_product_add")
    public String add(Product p) {
        p.setCreateDate(new Date());
        productService.add(p);
        return "redirect:admin_product_list?cid="+p.getCid();
    }
    @RequestMapping("admin_product_edit")
    public String edit(int id, Model model) {
        Product product = productService.get(id);
        Category category = categoryService.get(product.getCid());
        product.setCategory(category);
        model.addAttribute("p", product);
        return "admin/editProduct";
    }
    @RequestMapping("admin_product_update")
    public String update(Product p) {
        productService.update(p);
        return "redirect:admin_product_list?cid="+p.getCid();
    }
    @RequestMapping("admin_product_delete")
    public String delete(Integer id) {
        Product p = productService.get(id);
        productService.delete(id);
        return "redirect:admin_product_list?cid="+p.getCid();
    }
    @RequestMapping("foresearch")
    public String searchProducts(String keyword,Model model,String sort){
        List<Product> products = productService.searchBykeyword(keyword);
        productService.setSaleAndReviewNumber(products);
        setFirstProductImage(products);
        if(sort!=null){
            switch (sort){
                case "review":
                    Collections.sort(products,new ProductReviewComparator());
                    break;
                case "date":
                    Collections.sort(products,new ProductDateComparator());
                    break;
                case "saleCount":
                    Collections.sort(products,new ProductSaleCountComparator());
                    break;
                case "price":
                    Collections.sort(products,new ProductPriceComparator());
                case "all":
                    Collections.sort(products,new ProductAllComparator());
                default:

            }
        }
        model.addAttribute("products",products);
        model.addAttribute("keyword",keyword);
        return "fore/searchResult";
    }
}
