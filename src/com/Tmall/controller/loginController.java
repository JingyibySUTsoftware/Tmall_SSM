package com.Tmall.controller;

import com.Tmall.bean.User;
import com.Tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author jingyi
 * @Classname loginController
 * @description TODO
 * @date 2021/8/10 20:44
 */
@Controller
public class loginController {
    @Autowired
    private UserService userService;
    @RequestMapping("tologin")
    public String tologin(){
        return  "fore/login";
    }
    //登录并验证
    @RequestMapping("forelogin")
    public String loginCheck(User user, Model model, HttpServletRequest request){
        User nameAndID= userService.getUserNameAndID(user);
        HttpSession session = request.getSession();
        if(" ".equals(nameAndID)||nameAndID==null){
            String msg="账号或密码错误";
            model.addAttribute("msg",msg);
            return "fore/login";

        }else {
            session.setAttribute("nameAndID",nameAndID);
            return "forward:/forehome";
        }
    }
    //登出
    @RequestMapping("forelogout")
    public String logout(HttpSession session){
        session.removeAttribute("nameAndID");
        return "forward:/forehome";
    }

    @RequestMapping("forecheckLogin")
    @ResponseBody
    public  String checkLogin(HttpServletRequest request){
        User nameAndID = (User) request.getSession().getAttribute("nameAndID");
        if (nameAndID!=null)
            return "success";
        return "fail";
    }

    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String foreLogin(User user, HttpServletRequest request){
        User nameAndID= userService.getUserNameAndID(user);
        HttpSession session = request.getSession();
        if(" ".equals(nameAndID)||nameAndID==null){
            return "fail";
        }else {
            session.setAttribute("nameAndID",nameAndID);
            return "success";
        }
    }

}
