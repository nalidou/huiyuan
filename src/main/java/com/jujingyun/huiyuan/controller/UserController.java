package com.jujingyun.huiyuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.jujingyun.huiyuan.common.entity.User;
import com.jujingyun.huiyuan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Override
    public void init() {}

    @PostMapping("/login")
    public JSONObject login(String account, String password, HttpSession session) {
        JSONObject result = new JSONObject();
        User user = userService.login(account, password);
        if (user != null) {
            session.setAttribute("loginUser", user);
            addSuccess(result);
        } else {
            addFailed(result);
        }
        return result;
    }

    @GetMapping("/test")
    public JSONObject test(){
        JSONObject jsonObject = new JSONObject();
        addError(jsonObject, "测试: " + System.currentTimeMillis());
        return jsonObject;
    }


}
