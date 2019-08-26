package com.fang.springboot04webproject.config;

import com.fang.springboot04webproject.component.LoginHandlerInteceptor;
import com.fang.springboot04webproject.component.MylocaleResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Locale;

/**
 * 使用WebMvcConfigurerAdapter可以扩展SpringMVC功能
 * 这里主要目的是使得访问/,/index都能映射到首页
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    //所有的webMvcConfigurerAdapter组键都会一起起作用，所以这里直接加入新的处理url即可
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInteceptor()).addPathPatterns("/**").
                        excludePathPatterns("/","/index.html","/login.html","/login");
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");


            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MylocaleResolver();
    }
}
