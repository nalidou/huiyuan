package com.jujingyun.huiyuan.common._enum;

/**
 * 定义实体类info字段中的所有key
 */
public enum EntityInfoEnum {
    CREATE_TIME("createTime"),
    IS_DATETE("isDelete");

    private String name;

    EntityInfoEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
