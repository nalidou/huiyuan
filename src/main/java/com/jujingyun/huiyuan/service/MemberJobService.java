package com.jujingyun.huiyuan.service;

import com.jujingyun.huiyuan.common.entity.MemberJob;
import com.jujingyun.huiyuan.dao.MemberJobDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberJobService {

    private static final Logger log = LoggerFactory.getLogger(MemberJobService.class);

    @Resource
    private MemberJobDao memberJobDao;

    public boolean addMemberJob(String name, long usedId){
        try {
            MemberJob param = new MemberJob();
            param.setName(name);
            param.setUserId(usedId);

            if (memberJobDao.getListBy(param).size() == 0){
                MemberJob memberJob = MemberJob.generateNewMemberJob(name, usedId);
                memberJobDao.addOne(memberJob);
            }
            return true;
        } catch (Exception e) {
            log.error("addMemberJob failed", e);
            return false;
        }
    }

    public boolean deleteMemberJob(long id) {
        try {
            if (memberJobDao.delOne(id) == 1) {
                return true;
            }
        } catch (Exception e) {
            log.error("deleteMemberJob failed", e);
            return false;
        }
        return false;
    }

    public List<MemberJob> getListByUserId(long userId){
        try {
            return memberJobDao.getListByUserId(userId);
        } catch (Exception e) {
            log.error("getListByUserId failed", e);
            return null;
        }
    }


}
