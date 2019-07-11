package com.jujingyun.huiyuan.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.jujingyun.huiyuan.common.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession();
        System.out.println("拦截器。。。");
        User user = (User) session.getAttribute("loginUser");
        if(user == null){
            response.setHeader("content-type", "text/html;charset=utf-8");
            response.setContentType("text/html;charset=utf-8");
            JSONObject json = new JSONObject();
            json.put("404", "用户未登录");
            try {
                PrintWriter out = response.getWriter();
                out.print(json.toJSONString());
                out.flush();
                out.close();

            } catch (IOException e) {

            }
            return false;
        }
        return true;
    }
}
