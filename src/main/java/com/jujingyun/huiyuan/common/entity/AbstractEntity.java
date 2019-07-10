package com.jujingyun.huiyuan.common.entity;

import com.alibaba.fastjson.JSONObject;
import com.jujingyun.huiyuan.common.util.TimeUtil;

import java.text.ParseException;
import java.util.Date;


public abstract class AbstractEntity {

    private long id = 0L;
    private JSONObject infoJson = new JSONObject();
    private String createTimeStr = "";
    private long createTime = 0L;

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

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) throws ParseException {
        this.createTimeStr = createTimeStr;
        this.createTime = TimeUtil.timeFormat.parse(createTimeStr).getTime();
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
        this.createTimeStr = TimeUtil.timeFormat.format(new Date(createTime));
    }

    public abstract JSONObject toJSONObject();

}
