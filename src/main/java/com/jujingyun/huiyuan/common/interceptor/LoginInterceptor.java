package com.jujingyun.huiyuan.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.jujingyun.huiyuan.common._enum.ErrorCodeEnum;
import com.jujingyun.huiyuan.common.entity.User;
import com.jujingyun.huiyuan.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        if(user == null){
            response.setHeader("content-type", "text/html;charset=utf-8");
            response.setContentType("text/html;charset=utf-8");
            JSONObject json = new JSONObject();
            json.put(String.valueOf(ErrorCodeEnum.UNAUTHORIZED.getCode()), ErrorCodeEnum.UNAUTHORIZED.getMsg());
            try {
                PrintWriter out = response.getWriter();
                out.print(json.toJSONString());
                out.flush();
                out.close();
            } catch (IOException e) {}
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        log.info("REQUSET URI --- " + request.getRequestURI());
    }
}
