package com.fang.springboot04webproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

/**
 * thymeleaf自动配置中会默认加上classpath:/template/前缀和.html后缀
 * 所以请求需要在templates文件夹下有html页面
 */
@Controller
public class ThymleafTestController {

    /**
     * 怎么在这个方法中添加数据并且在html页面中取出？：
            *  1.在传入参数中定义一个map键值对
     *  2.向map中存储键值对
     *  3.在html页面中取出（JSP使用${键}来取出），可以导入thymeleaf名称空间（在html中，主要作用是语法提示）
            *  <html lang="en" xmlns:th="http://www.thymleaf.org">
            *  4.thymleaf需要在th:text（或者其他）中加${键来取值}
     *  <div th:text="${hello}"></div>
            * @return
            */
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>数据</h1>");
        map.put("users", Arrays.asList("qq","qqq","qqqq"));
        return "success";
    }
}
