package com.jujingyun.huiyuan.dao;

import com.jujingyun.huiyuan.HuiyuanApplication;
import com.jujingyun.huiyuan.common.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = HuiyuanApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void test() {
        User user = new User();
        user.setName("吴兆跃2");
        user.setPassword("21331ZWqd!.';.'");
        user.setInfoOf("createTime", System.currentTimeMillis());
        System.out.println(user.toJSONObject());
        System.out.println(userDao.getByName("吴兆跃2").getInfoOf("createTime"));
        //System.out.println(userDao.addOne(user));
    }

}