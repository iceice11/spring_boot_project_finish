package com.fang.springboot04webproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 用来处理登入操作
 */
@Controller
public class LoginController {

    @PostMapping(value = "/login")
    //@RequestMapping(value = "/login", method = RequestMethod.POST)   与上面是等价的
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(username.equals("admin") && password.equals("123456")) {
            //将已登入的用户加入session中，为了方便后面的拦截检测
            session.setAttribute("loginUser",username);
            //如果账户不对则重定向到main页面，main在mvc解析中已经设置了会自动跳转至dashboard页面，这样可以防止重复提交表单
            return "redirect:/main.html";
        }
        //登入失败
        map.put("msg","用户名或者密码错误");
        return "login";
    }
}
