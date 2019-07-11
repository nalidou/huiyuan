package com.jujingyun.huiyuan.service;

import com.jujingyun.huiyuan.common.entity.MemberJob;
import com.jujingyun.huiyuan.dao.MemberJobDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberJobService {

    private static final Logger log = LoggerFactory.getLogger(MemberJobService.class);

    @Resource
    private MemberJobDao memberJobDao;

    public boolean addMemberJob(String name, long usedId){
        try {
            MemberJob memberJob = MemberJob.generateNewMemberJob(name, usedId);
            memberJobDao.addOne(memberJob);
            return true;
        } catch (Exception e) {
            log.error("addMemberJob failed", e);
            return false;
        }
    }
}
