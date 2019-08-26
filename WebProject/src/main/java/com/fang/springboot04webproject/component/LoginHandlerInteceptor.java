package com.fang.springboot04webproject.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登入检测的拦截器：为了防止未登入状态客户跳过登入直接通过ip访问其他页面
 */
public class LoginHandlerInteceptor implements HandlerInterceptor {
    //预检测，在执行操作前要进行预检验
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");//拿到session中的这个变量
        if(user == null){
            //未登入用户,并且返回登入页，给出错误信息
            //获取拦截器，并转发至登入页面
            request.setAttribute("msg","权限不足，请先登入");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else{
            //已登入
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
