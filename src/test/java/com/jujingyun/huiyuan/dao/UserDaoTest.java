package com.jujingyun.huiyuan.dao;

import com.jujingyun.huiyuan.HuiyuanApplication;
import com.jujingyun.huiyuan.common._enum.EntityInfoEnum;
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
        //User user = User.generateNewUser("吴赵越1","123");
        //user.setInfoOf(EntityInfoEnum.UPDATE_TIME.getName(), System.currentTimeMillis());
        //System.out.println(userDao.addOne(user));

       // User u = userDao.getAll().get(0);
        //u.setInfoOf("aa","bb");
        //System.out.println(userDao.updateOne(u));
        System.out.println(userDao.getByAccount("吴赵越1")==null);
    }

}