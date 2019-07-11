package com.jujingyun.huiyuan.dao;

import com.jujingyun.huiyuan.HuiyuanApplication;
import com.jujingyun.huiyuan.common.entity.MemberJob;
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
public class MemberJobDaoTest {

    @Resource
    private MemberJobDao memberJobDao;

    @Test
    public void test(){
        MemberJob memberJob = MemberJob.generateNewMemberJob("阿斯蒂芬aa", 231441);

        //System.out.println(memberJobDao.addOne(memberJob));
        //System.out.println(memberJobDao.addOne(memberJob));
        System.out.println(memberJobDao.getListByUserId(231441).size());
        System.out.println(memberJobDao.delOne(1));
    }

}