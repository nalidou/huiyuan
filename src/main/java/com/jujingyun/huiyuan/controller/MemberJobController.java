package com.jujingyun.huiyuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.jujingyun.huiyuan.common.entity.MemberJob;
import com.jujingyun.huiyuan.common.entity.User;
import com.jujingyun.huiyuan.service.MemberJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 商会职务
 */

@RestController
@RequestMapping("/memberJob")
public class MemberJobController extends AbstractController{

    private static final Logger log = LoggerFactory.getLogger(MemberJobController.class);

    @Autowired
    private MemberJobService memberJobService;

    @PostMapping("/addMemberJob")
    public JSONObject addMemberJob(String name, HttpSession session){
        JSONObject result = new JSONObject();
        User user = (User) session.getAttribute("loginUser");
        if (memberJobService.addMemberJob(name, user.getId())) {
            addSuccess(result);
        } else {
            addFailed(result);
        }
        return result;
    }


    @Override
    public void init() {

    }
}
