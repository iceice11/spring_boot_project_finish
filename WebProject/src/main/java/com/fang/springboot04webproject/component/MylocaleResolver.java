package com.fang.springboot04webproject.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 区域解析信息的类：目的是为了可以手动切换区域信息
 */
public class MylocaleResolver implements LocaleResolver {
    /**
     * 根据请求的信息来判断语言：前端页面中会在点击下方语言时加入请求信息l
     * @param request
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale = Locale.getDefault();           //如果没有语言选择，则使用默认值
        if(!StringUtils.isEmpty(l)){
            String[] s = l.split("_");
            locale = new Locale(s[0],s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
