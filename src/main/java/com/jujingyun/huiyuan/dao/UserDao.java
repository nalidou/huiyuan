package com.jujingyun.huiyuan.dao;

import com.jujingyun.huiyuan.entity.User;

import java.util.List;

public interface UserDao {

    //List<User> getAll();
    User getByName(String name);
    int addOne(User user);
    //int updateOne(User user);

}