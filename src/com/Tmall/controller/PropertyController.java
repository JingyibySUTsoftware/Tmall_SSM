package com.Tmall.controller;

import com.Tmall.bean.Category;
import com.Tmall.bean.Property;
import com.Tmall.service.CategoryService;
import com.Tmall.service.PropertyService;
import com.Tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author jingyi
 * @Classname PropertyController
 * @description TODO
 * @date 2021/8/3 10:31
 */
@Controller
public class PropertyController {
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("admin_property_list")
    public String listProperty(int cid, Model model, Page page) {
        Category category = categoryService.get(cid);
        List<Property> pslist = propertyService.list(page.getStart(),page.getCount(),cid);
        int total=propertyService.total(cid);
        page.setTotal(total);
        page.setParam("&cid="+category.getId());
        model.addAttribute("pslist", pslist);
        model.addAttribute("category", category);
        model.addAttribute("page", page);
        return "admin/listProperty";
    }
    @RequestMapping("admin_property_add")
    public String add(Property p) {
        propertyService.add(p);
        return "redirect:admin_property_list?cid="+p.getCid();
    }
    @RequestMapping("admin_property_edit")
    public String edit(Model model, Integer id) {
        Property property = propertyService.get(id);
        Category category = categoryService.get(property.getCid());
        property.setCategory(category);
        model.addAttribute("p",property);
        return "admin/editProperty";
    }
    @RequestMapping("admin_property_update")
    public String update(Property p) {
        propertyService.update(p);
        return "redirect:admin_property_list?cid="+p.getCid();
    }
    @RequestMapping("admin_property_delete")
    public String delete(Integer id) {
        Property p = propertyService.get(id);
        propertyService.delete(id);
        return "redirect:admin_property_list?cid="+p.getCid();
    }
}

