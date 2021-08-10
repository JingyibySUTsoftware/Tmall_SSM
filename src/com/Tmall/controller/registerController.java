package com.Tmall.controller;

import com.Tmall.bean.User;
import com.Tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jingyi
 * @Classname registerController
 * @description TODO
 * @date 2021/8/10 11:26
 */
@Controller
public class registerController {
    @Autowired
    private UserService userService;
    @RequestMapping("checkName")
    @ResponseBody
    public String registerCheck(String name){
        boolean flag=userService.userNameisExist(name);
        if(flag){
            return "default";
        }else {
            return  "success";
        }
    }
    @RequestMapping("foreregister")
    public String addnewUser(User user){
        userService.userAdd(user);
        return "redirect:registerSuccess";
    }
}
