package com.jujingyun.huiyuan.common.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * 会员性质实体类
 */
public class MemberProperty extends AbstractEntity{

    private String name;
    private long userId;

    public MemberProperty(){}

    public static MemberProperty generateNewMemberProperty(String name, long userId) {
        MemberProperty memberProperty = new MemberProperty();
        memberProperty.setName(name);
        memberProperty.setUserId(userId);
        memberProperty.setCreateTime(System.currentTimeMillis());
        return memberProperty;
    }

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
