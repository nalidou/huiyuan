package com.jujingyun.huiyuan.common._enum;

/**
 * 定义实体类info字段中的所有key
 */
public enum EntityInfoEnum {
    //更新时间
    UPDATE_TIME("updateTime");

    private String name;

    EntityInfoEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
