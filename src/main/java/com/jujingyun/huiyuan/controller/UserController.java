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

    @RequestMapping("/login")
    public JSONObject login(String account, String password, HttpSession session) {
        JSONObject result = new JSONObject();
        User user = userService.login(account, password);
        if (user != null) {
            session.setMaxInactiveInterval(60 * 60 * 24);
            session.setAttribute("loginUser", user);
            addSuccess(result);
            result.put("userId", user.getId());
            result.put("account", user.getAccount());
        } else {
            addFailed(result);
        }
        return result;
    }

    @RequestMapping("/logout")
    public JSONObject logout(HttpSession session) {
        JSONObject result = new JSONObject();
        session.removeAttribute("loginUser");
        addSuccess(result);
        return result;
    }



    @GetMapping("/test")
    public JSONObject test(){
        JSONObject jsonObject = new JSONObject();
        addSuccess(jsonObject);
        return jsonObject;
    }


}
