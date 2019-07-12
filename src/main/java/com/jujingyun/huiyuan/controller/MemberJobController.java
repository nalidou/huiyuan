package com.jujingyun.huiyuan.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jujingyun.huiyuan.common.entity.Member;
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
import java.util.List;

/**
 * 商会职务
 */

@RestController
@RequestMapping("/memberJob")
public class MemberJobController extends AbstractController{

    private static final Logger log = LoggerFactory.getLogger(MemberJobController.class);

    @Autowired
    private MemberJobService memberJobService;

    @RequestMapping("/addMemberJob")
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

    @RequestMapping("/deleteMemberJob")
    public JSONObject deleteMemberJob(long id){
        JSONObject result = new JSONObject();
        if (memberJobService.deleteMemberJob(id)) {
            addSuccess(result);
        } else {
            addFailed(result);
        }
        return result;
    }

    @RequestMapping("/getAll")
    public JSONObject getAll(HttpSession session){
        JSONObject result = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        User user = (User) session.getAttribute("loginUser");
        List<MemberJob> list = memberJobService.getListByUserId(user.getId());
        for (MemberJob memberJob : list) {
            jsonArray.add(memberJob.toJSONObject());
        }
        addSuccess(result);
        result.put("list", jsonArray);
        return result;
    }


    @Override
    public void init() {

    }
}
