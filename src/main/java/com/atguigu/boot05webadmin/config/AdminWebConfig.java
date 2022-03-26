package com.atguigu.boot05webadmin.config;

import com.atguigu.boot05webadmin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 1.编写一个拦截器实现HandlerInterceptor
 * 2.拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors方法）
 * 3.指定拦截规则（如果是拦截所有，静态资源也会被拦截）
 */
@Configuration
//定制web功能都是实现WebMvcConfigurer接口
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//静态所有请求都被拦截
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");
    }
}
