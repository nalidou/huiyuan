package com.jujingyun.huiyuan.common.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * 会员性质实体类
 */
public class MemberProperty extends AbstractEntity{

    private String name;

    public MemberProperty(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        json.put("id", getId());
        json.put("name", getName());
        json.put("info", getInfo());
        return json;
    }
}
