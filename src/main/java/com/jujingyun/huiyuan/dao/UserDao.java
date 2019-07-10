package com.jujingyun.huiyuan.dao;

import com.jujingyun.huiyuan.common.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();
    User getByAccount(String account);
    int addOne(User user);
    int updateOne(User user);

}
