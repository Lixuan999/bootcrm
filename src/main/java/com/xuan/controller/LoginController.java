package com.xuan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@RequestMapping
@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Model model) {
        //如果用户名和密码正确
        if ("XloveZ".equals(username) && "211314".equals(password)) {
            session.setAttribute("LoginUser",username);
            return "redirect:/nls.html";//跳转到dashboard页面
        }else {
            model.addAttribute("msg","用户名或者密码错误");
            return "index";
        }
    }
    @RequestMapping("/user/loginout")
    public String loginout(HttpSession session){
        //清除已定义的session
        session.invalidate();
        return "redirect:index.html";
    }
}

