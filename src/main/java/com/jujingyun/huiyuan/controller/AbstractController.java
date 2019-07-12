package com.jujingyun.huiyuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.jujingyun.huiyuan.common._enum.ErrorCodeEnum;
import com.jujingyun.huiyuan.common.entity.User;

import javax.servlet.http.HttpSession;

public abstract class AbstractController {

    public abstract void init();

    public User getUser(HttpSession session){
        User user = (User) session.getAttribute("loginUser");
        return user;
    }

    public void addError(JSONObject json, String str) {
        json.put("responseCode", ErrorCodeEnum.ERROR.getCode());
        json.put("responseMsg", ErrorCodeEnum.ERROR.getMsg());
        json.put("responseDetail", str);
    }

    public void addSuccess(JSONObject json) {
        json.put("responseCode", ErrorCodeEnum.SUCCESS.getCode());
        json.put("responseMsg", ErrorCodeEnum.SUCCESS.getMsg());
    }

    public void addFailed(JSONObject json) {
        json.put("responseCode", ErrorCodeEnum.FAILED.getCode());
        json.put("responseMsg", ErrorCodeEnum.FAILED.getMsg());
    }



}
