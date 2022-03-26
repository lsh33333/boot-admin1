package com.atguigu.boot05webadmin.controller;


import com.atguigu.boot05webadmin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping("/acct")
    public User getbyId(){
        return null;
    }




    /**
     * 来登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){

        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if ((user.getUserName()!=null)&&"123456".equals(user.getPassword())){
            //把登陆用户保存起来
            session.setAttribute("loginUser",user);
            //登录成功后重定向到main.html,重定向到表单防止重读提交

            //默认是转发，所以已刷新还是post的login请求，导致表单重复提交(页面转到main了，但是请求还是login)
            //如果是重定向的话（重定向多发一次请求），刷新就是main页面的刷新
            //登录成功重定向到main.html
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","重新登录");
            //回到登录页
            return "login";
        }
    }

    /**
     * 去main页面
     * @return
     */
    //加后缀，跳转页面
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        //是否登录    不能给每个方法写，所以最好用拦截器，或过滤器
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser!=null){
//            return "main";
//        }else {
//            //回到登录页
//            model.addAttribute("msg","账号密码错误");
//            return "login";
//        }
        //登录检查已近在拦截器的地方做过了
        return "main";
    }

}
