package com.jujingyun.huiyuan.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jujingyun.huiyuan.common.entity.Member;
import com.jujingyun.huiyuan.common.entity.User;
import com.jujingyun.huiyuan.common.util.ExcelUtil;
import com.jujingyun.huiyuan.common.util.FileUtil;
import com.jujingyun.huiyuan.common.util.TimeUtil;
import com.jujingyun.huiyuan.service.MemberService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
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
    public JSONObject update(Member member) {
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

    @RequestMapping("/getById")
    public JSONObject getById(long id, HttpSession session){
        User user = (User)getUser(session);
        JSONObject result = new JSONObject();
        Member member = memberService.getById(id, user.getId());
        if (member != null) {
            result.put("member", member.toJSONObject());
            addSuccess(result);
        } else {
            addFailed(result);
        }
        return result;
    }

    //导出
    @RequestMapping("/exportExcel")
    public JSONObject exportExcel(@RequestParam(value = "mobilephone", defaultValue = "") String mobilephone,
                             @RequestParam(value = "name", defaultValue = "") String name,
                             @RequestParam(value = "memberJob" ,defaultValue = "") String memberJob,
                             @RequestParam(value = "startTime", defaultValue = "") String startTime,
                             @RequestParam(value = "endTime", defaultValue = "") String endTime,
                             HttpServletResponse response, HttpSession session) {


        User user = getUser(session);
        Member param = new Member();
        param.setUserId(user.getId());
        param.setMobilephone(mobilephone);
        param.setName(name);
        param.setMemberJob(memberJob);
        param.setStartTime(TimeUtil.dateStr2Time(startTime));
        param.setEndTime(TimeUtil.dateStr2Time(endTime));

        memberService.exportMemberExcel(param, response);
        return null;
    }

    //导入
    @RequestMapping("/uploadExcel")
    public JSONObject uploadExcel(HttpServletRequest request,
                                  HttpServletResponse response,
                                  HttpSession session,
                                  MultipartFile file){
        JSONObject result = new JSONObject();
        User user = getUser(session);

        if (memberService.parseExcel(file, user.getId())) {
            addSuccess(result);
        } else {
            addFailed(result);
        }
        return result;
    }



    @RequestMapping("/download")
    public void download(HttpServletRequest request,
                         HttpServletResponse response){
        List<List<String>> dataList = new ArrayList<>();
        for (int i=0; i<10; i++) {
            List<String> data = new ArrayList<>();
            data.add("id" + i);
            data.add("姓名姓名姓名姓名姓名姓名姓名姓名姓名姓名" + i);
            data.add("age" + i);
            data.add("address" + i);

            dataList.add(data);
        }
        String[] titles = new String[] {
                "序号", "姓名", "性别", "年龄", "民族",
                "籍贯", "学历", "身份证", "出生年月", "邮编",
                "手机号", "固定电话", "邮箱", "家庭地址", "企业名称",
                "企业职务", "职务情况", "公司地址", "会员性质", "所在商会",
                "会员职务", "加入日期", "推荐人", "会费状态", "备注"
        };
        System.out.println(dataList.toString());
        XSSFWorkbook excel = ExcelUtil.createExcel2007("会员信息",titles, dataList);

        FileUtil.downloadExcel(excel, response, TimeUtil.time2TimeStrNum(System.currentTimeMillis()));

    }


    @Override
    public void init() {

    }
}
