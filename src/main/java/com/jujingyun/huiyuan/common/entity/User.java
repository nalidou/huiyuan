package com.jujingyun.huiyuan.common.entity;

import com.alibaba.fastjson.JSONObject;
import com.jujingyun.huiyuan.common._enum.EntityInfoEnum;

/**
 * 用户实体类
 */
public class User extends AbstractEntity{

    private String account = "";
    private String password = "";
    private int level = 1;//权限等级 1:普通用户
    private int isUsed = 1;//是否在用 0:未用，1:在用

    public User(){}

    public static User generateNewUser(String account, String password){
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setCreateTime(System.currentTimeMillis());
        user.setInfoOf(EntityInfoEnum.UPDATE_TIME.getName(), System.currentTimeMillis());
        return user;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(int isUsed) {
        this.isUsed = isUsed;
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        json.put("id", getId());
        json.put("account", getAccount());
        json.put("passowrd", getPassword());
        json.put("level", getLevel());
        json.put("isUsed", getIsUsed());
        json.put("info", getInfo());
        json.put("createTime", getCreateTime());
        json.put("createTimeStr", getCreateTimeStr());
        return json;
    }
}
