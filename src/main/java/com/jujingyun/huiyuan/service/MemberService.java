package com.jujingyun.huiyuan.service;

import com.jujingyun.huiyuan.common.entity.Member;
import com.jujingyun.huiyuan.common.util.ExcelUtil;
import com.jujingyun.huiyuan.common.util.FileUtil;
import com.jujingyun.huiyuan.common.util.TimeUtil;
import com.jujingyun.huiyuan.controller.MemberController;
import com.jujingyun.huiyuan.dao.MemberDao;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    private static final Logger log = LoggerFactory.getLogger(MemberService.class);

    @Resource
    private MemberDao memberDao;

    public boolean addOrUpdateMember(Member member, long userId) {
        try {
            if (member.getId() == 0) {
                //添加
                Member newMember = Member.generateNewMember(member, userId);
                int result = memberDao.addOne(newMember);
                if (result > 0) {
                    return true;
                }
            } else {
                //更新
                int result = memberDao.updateOne(member);
                if (result > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            log.error("addOrUpdateMember failed", e);
            return false;
        }
        return false;
    }

    public boolean deleteMember(long id){
        try {
            int result = memberDao.updateIsDelete(id, 0);
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            log.error("updateMember failed", e);
            return false;
        }
        return false;
    }

    public List<Member> getListBy(Member param) {
        try {
            return memberDao.getListBy(param);
        } catch (Exception e) {
            log.error("getListBy failed", e);
            return null;
        }
    }

    public Member getById(long id, long userId) {
        Member member = memberDao.getById(id);
        if (member.getUserId() == userId) {
            return member;
        } else {
            return null;
        }
    }

    public void exportMemberExcel(Member param, HttpServletResponse response){
        try {
            List<Member> list = getListBy(param);
            List<List<String>> dataList = new ArrayList<List<String>>();
            for (Member member : list){
                List<String> data = new ArrayList<String>();
                data.add(String.valueOf(member.getId()));
                data.add(member.getName());
                data.add(member.getSexStr());
                data.add(member.getNation());

                data.add(member.getNativeAddress());
                data.add(member.getEduBackground());
                data.add(member.getIdCard());
                data.add(member.getBirthday());

                data.add(member.getMobilephone());
                data.add(member.getTelephone());
                data.add(member.getEmail());
                data.add(member.getHomeAdderss());
                data.add(member.getCompanyName());

                data.add(member.getCompanyJob());
                data.add(member.getCompanyStatusStr());
                data.add(member.getCompanyAddress());
                data.add(member.getMemberProperty());
                data.add(member.getMemberName());

                data.add(member.getMemberJob());
                data.add(member.getMemberEnterDateStr());
                data.add(member.getMemberReferrer());
                data.add(member.getMemberStatusStr());
                data.add(member.getMemo());

                dataList.add(data);
            }
            String[] titles = new String[] {
                    "序号", "姓名", "性别", "年龄", "民族",
                    "籍贯", "学历", "身份证", "出生年月",
                    "手机号", "固定电话", "邮箱", "家庭地址", "企业名称",
                    "企业职务", "职务情况", "公司地址", "会员性质", "所在商会",
                    "会员职务", "加入日期", "推荐人", "会费状态", "备注"
            };
            String sheetName = "会员信息";
            XSSFWorkbook excel = ExcelUtil.createExcel2007(sheetName, titles, dataList);
            FileUtil.downloadExcel(excel, response, TimeUtil.time2TimeStrNum(System.currentTimeMillis()) + ".xls");
        } catch (Exception e) {
            log.error("exportMemberExcel", e);
        }
    }

    public boolean parseExcel(MultipartFile file, long userId){
        try {
            List<List<String>> dataList = ExcelUtil.readExcel(file);
            for (List<String> data : dataList) {
                StringBuilder sb = new StringBuilder();
                for (String d : data) {
                    sb.append(d+" ");
                }
                log.info("解析excel: " + sb.toString());
            }
            return true;
        } catch (Exception e) {
            log.error("parseExcel failed", e);
            return false;
        }

    }
}
