package com.jujingyun.huiyuan.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jujingyun.huiyuan.common.entity.MemberJob;
import com.jujingyun.huiyuan.common.entity.MemberProperty;
import com.jujingyun.huiyuan.common.entity.User;
import com.jujingyun.huiyuan.service.MemberJobService;
import com.jujingyun.huiyuan.service.MemberPropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 会员性质
 */

@RestController
@RequestMapping("/memberProperty")
public class MemberPropertyController extends AbstractController{

    private static final Logger log = LoggerFactory.getLogger(MemberPropertyController.class);

    @Autowired
    private MemberPropertyService memberPropertyService;

    @RequestMapping("/add")
    public JSONObject add(String name, HttpSession session){
        JSONObject result = new JSONObject();
        User user = getUser(session);
        if (memberPropertyService.addMemberProperty(name, user.getId())) {
            addSuccess(result);
        } else {
            addFailed(result);
        }
        return result;
    }

    @RequestMapping("/delete")
    public JSONObject delete(long id){
        JSONObject result = new JSONObject();
        if (memberPropertyService.deleteMemberProperty(id)) {
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
        User user = getUser(session);
        List<MemberProperty> list = memberPropertyService.getListByUserId(user.getId());
        for (MemberProperty memberProperty : list) {
            jsonArray.add(memberProperty.toJSONObject());
        }
        addSuccess(result);
        result.put("list", jsonArray);
        return result;
    }



    @Override
    public void init() {

    }
}
