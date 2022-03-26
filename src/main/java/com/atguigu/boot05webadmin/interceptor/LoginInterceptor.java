package com.atguigu.boot05webadmin.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录检查
 * 1.配置好拦截器要拦截那些请求
 * 2.把这些配置放在容器中
 */
//lombak提供的
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    //目标方法执行前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //slf4j提供的日志对象
        String requestURI = request.getRequestURI();
        log.info("拦截的请求路径是:"+requestURI);

        //登录检查逻辑
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser!=null){
            //放行
            return true;
        }
        //拦截

        //session.setAttribute("msg","请先登录");
        //response.sendRedirect("/");   这种重定向方法取不出来东西
        request.setAttribute("msg","请先登录");//用转发的方法
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }

    //目标方法执行后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //页面渲染后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
