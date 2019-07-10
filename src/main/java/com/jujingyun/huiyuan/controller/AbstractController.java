package com.jujingyun.huiyuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.jujingyun.huiyuan.common._enum.ErrorCodeEnum;

public abstract class AbstractController {

    public abstract void init();

    public void addError(JSONObject json, String str) {
        json.put("responseCode", ErrorCodeEnum.ERROR.getCode());
        json.put("responseMsg", ErrorCodeEnum.ERROR.getMsg());
    }


}
