package com.jujingyun.huiyuan.service;

import com.jujingyun.huiyuan.common.entity.User;
import com.jujingyun.huiyuan.dao.MemberJobDao;
import com.jujingyun.huiyuan.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserDao userDao;

    public User getUserByAccount(String account) {
        try {
            return userDao.getByAccount(account);
        } catch (Exception e) {
            log.error("getUserByAccount", e);
            return null;
        }
    }

    public User login(String account, String password) {
        try {
            User user = userDao.getByAccount(account);
            if (user != null && user.getPassword().equals(password) && user.getIsUsed()==1) {
                return user;
            }
        } catch (Exception e) {
            log.error("login failed", e);
            return null;
        }
        return null;
    }


}
