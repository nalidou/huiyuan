package com.jujingyun.huiyuan.entity;

import com.alibaba.fastjson.JSONObject;

public class User {
    private long id = 0L;
    private String name = "";
    private String password = "";
    private JSONObject infoJson = new JSONObject();

    public User(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInfo() {
        return infoJson.toString();
    }

    public void setInfo(String info) {
        infoJson = JSONObject.parseObject(info);
    }

    public void setInfoOf(String key, Object value) {
        infoJson.put(key, value);
    }

    public Object getInfoOf(String key) {
        return infoJson.get(key);
    }

    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        json.put("id", getId());
        json.put("name", getName());
        json.put("passowrd", getPassword());
        json.put("info", getInfo());
        return json;
    }
}
