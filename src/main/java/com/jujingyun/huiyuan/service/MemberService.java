package com.jujingyun.huiyuan.service;

import com.jujingyun.huiyuan.common.entity.Member;
import com.jujingyun.huiyuan.common.util.ExcelUtil;
import com.jujingyun.huiyuan.common.util.FileUtil;
import com.jujingyun.huiyuan.common.util.TimeUtil;
import com.jujingyun.huiyuan.controller.MemberController;
import com.jujingyun.huiyuan.dao.MemberDao;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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

    public void exportMemberExcel(Member param, HttpServletResponse response){
        try {
            List<Member> list = getListBy(param);
            List<List<String>> dataList = new ArrayList<List<String>>();
            for (Member member : list){
                List<String> data = new ArrayList<String>();
                data.add(String.valueOf(member.getId()));
                data.add(String.valueOf(member.getName()));

                dataList.add(data);
            }
            HSSFWorkbook excel = ExcelUtil.getExcel(dataList);
            FileUtil.downloadExcel(excel, response, TimeUtil.time2TimeStrNum(System.currentTimeMillis()) + ".xls");
        } catch (Exception e) {
            log.error("exportMemberExcel", e);
        }
    }

    public boolean parseExcel(MultipartFile file, long userId){
        try {
            List<List<String>> dataList = ExcelUtil.readExcel(file);
            return true;
        } catch (Exception e) {
            log.error("parseExcel failed", e);
            return false;
        }

    }
}
