package com.jujingyun.huiyuan.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController {
    @Override
    public void init() {

    }

    @GetMapping("/test")
    public JSONObject test(){
        JSONObject jsonObject = new JSONObject();
        addError(jsonObject, "测试！。，safa");

        return jsonObject;
    }


}
