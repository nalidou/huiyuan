package com.jujingyun.huiyuan.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * 商会职务实体类
 */
public class MemberJob extends AbstractEntity{

    private String name;

    public MemberJob(){}

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
