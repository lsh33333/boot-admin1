package com.atguigu.boot05webadmin.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

//proxyBeanMethods属性：：：(proxyBeanMethods = false)
@Configuration(proxyBeanMethods = true)//默认是true，保证我们依赖的组件是单实例的
public class MyRegistConfig {

//    Bean注解：：：Spring的@Bean注解用于告诉方法，产生一个Bean对象，
//    然后这个Bean对象交给Spring管理。产生这个Bean对象的方法Spring只会调用一次，
//    随后这个Spring将会将这个Bean对象放在自己的IOC容器中。
    @Bean
    public ServletRegistrationBean myServlet(){
        //为什么我们这个servlet没有经过拦截器？
        //DispatcherServlet(spring流程)---->处理/请求
        //MyServlet(tomcat处理)---->处理/my请求   越精确越优先，所以不会经过dispatcherServlet
        // （没有经过spring的流程，不会触发拦截器）

        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean(myServlet,"/my","/my02");
    }

    @Bean
    public FilterRegistrationBean MyFilter(){
        MyFilter myFilter = new MyFilter();
        //写法一：myServlet拦截什么路劲 我们就拦截什么路劲
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));
        return new FilterRegistrationBean(myFilter,myServlet());
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyServletContextListener myServletContextListener = new MyServletContextListener();
        return new ServletListenerRegistrationBean(myServletContextListener);
    }



}
