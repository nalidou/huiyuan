package com.jujingyun.huiyuan.service;

import com.jujingyun.huiyuan.common.entity.Member;
import com.jujingyun.huiyuan.controller.MemberController;
import com.jujingyun.huiyuan.dao.MemberDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
