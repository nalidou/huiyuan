package com.jujingyun.huiyuan.dao;

import com.jujingyun.huiyuan.HuiyuanApplication;
import com.jujingyun.huiyuan.common.entity.Member;
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
public class MemberDaoTest {

    @Resource
    private MemberDao memberDao;

    @Test
    public void test(){

        Member member = new Member();


    }

}