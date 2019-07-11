package com.jujingyun.huiyuan.dao;

import com.jujingyun.huiyuan.HuiyuanApplication;
import com.jujingyun.huiyuan.common.entity.MemberProperty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = HuiyuanApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
public class MemberPropertyDaoTest {

    @Resource
    private MemberPropertyDao memberPropertyDao;

    @Test
    public void test(){
        MemberProperty memberProperty = MemberProperty.generateNewMemberProperty("小明", 23425234);
        //System.out.println(memberPropertyDao.addOne(memberProperty));
        //System.out.println(memberPropertyDao.getListByUserId(23425234).get(1).toJSONObject());
        System.out.println(memberPropertyDao.delOne(1));
    }

}