package com.jujingyun.huiyuan.common.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * 商会职务实体类
 */
public class MemberJob extends AbstractEntity{

    private String name;
    private long userId;

    public MemberJob(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        json.put("id", getId());
        json.put("name", getName());
        json.put("info", getInfo());
        json.put("createTime", getCreateTime());
        json.put("createTimeStr", getCreateTimeStr());
        json.put("userId", getUserId());
        return json;
    }
}
