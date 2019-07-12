package com.jujingyun.huiyuan.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jujingyun.huiyuan.common.entity.Member;
import com.jujingyun.huiyuan.common.entity.User;
import com.jujingyun.huiyuan.common.util.TimeUtil;
import com.jujingyun.huiyuan.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController extends AbstractController {

    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    @RequestMapping("/add")
    public JSONObject add(Member member, HttpSession session) {
         User user = getUser(session);
         JSONObject result = new JSONObject();
         if (memberService.addOrUpdateMember(member, user.getId())) {
             addSuccess(result);
         } else {
             addFailed(result);
         }
         return result;
    }

    @RequestMapping("/update")
    public JSONObject add(Member member) {
        JSONObject result = new JSONObject();
        if (memberService.addOrUpdateMember(member, 0L)) {
            addSuccess(result);
        } else {
            addFailed(result);
        }
        return result;
    }

    @RequestMapping("/delete")
    public JSONObject delete(long id) {
        JSONObject result = new JSONObject();
        if (memberService.deleteMember(id)) {
            addSuccess(result);
        } else {
            addFailed(result);
        }
        return result;
    }

    @RequestMapping("/search")
    public JSONObject search(@RequestParam(value = "mobilephone", defaultValue = "") String mobilephone,
                             @RequestParam(value = "name", defaultValue = "") String name,
                             @RequestParam(value = "memberJob" ,defaultValue = "") String memberJob,
                             @RequestParam(value = "startTime", defaultValue = "") String startTime,
                             @RequestParam(value = "endTime", defaultValue = "") String endTime,
                             @RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                             HttpSession session) {
        JSONObject result = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        User user = getUser(session);
        Member param = new Member();
        param.setUserId(user.getId());
        param.setMobilephone(mobilephone);
        param.setName(name);
        param.setMemberJob(memberJob);
        param.setStartTime(TimeUtil.dateStr2Time(startTime));
        param.setEndTime(TimeUtil.dateStr2Time(endTime));
        param.setPageIndex(pageIndex);
        param.setPageSize(pageSize);

        List<Member> list = memberService.getListBy(param);
        for (Member member : list) {
            jsonArray.add(member.toJSONObject());
        }
        result.put("list", jsonArray);
        addSuccess(result);

        return result;
    }



    @Override
    public void init() {

    }
}
