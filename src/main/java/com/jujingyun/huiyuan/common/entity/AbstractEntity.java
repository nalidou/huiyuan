package com.jujingyun.huiyuan.common.entity;

import com.alibaba.fastjson.JSONObject;

public abstract class AbstractEntity {

    private long id = 0L;
    private JSONObject infoJson = new JSONObject();

    public AbstractEntity(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public abstract JSONObject toJSONObject();

}
