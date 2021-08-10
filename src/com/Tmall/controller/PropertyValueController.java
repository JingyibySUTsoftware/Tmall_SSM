package com.Tmall.controller;

import com.Tmall.bean.Product;
import com.Tmall.bean.PropertyValue;
import com.Tmall.service.ProductService;
import com.Tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author jingyi
 * @Classname PropertyValueController
 * @description TODO
 * @date 2021/8/3 10:33
 */
@Controller
public class PropertyValueController {
    @Autowired
    private PropertyValueService propertyValueService;
    @Autowired
    private ProductService productService;
    @RequestMapping("admin_propertyValue_edit")
    public String getPV(Integer pid, Model model) {
        Product product = productService.get(pid);
        propertyValueService.init(product);
        List<PropertyValue> pvlist = propertyValueService.getPvByPid(pid);
        model.addAttribute("pvlist", pvlist);
        model.addAttribute("p", product);
        return "admin/editPropertyValue";
    }
    @RequestMapping("admin_propertyValue_update")
    @ResponseBody
    public String updatePvByid(PropertyValue p) {
        int effnum = propertyValueService.updateVByid(p);
        if(effnum>0) {
            return "success";
        }
        else {
            return "defeat";
        }
    }
}
