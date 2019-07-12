package com.jujingyun.huiyuan.service;


import com.jujingyun.huiyuan.common.entity.MemberProperty;
import com.jujingyun.huiyuan.dao.MemberPropertyDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberPropertyService {

    private static final Logger log = LoggerFactory.getLogger(MemberJobService.class);

    @Resource
    private MemberPropertyDao memberPropertyDao;

    public boolean addMemberProperty(String name, long usedId){
        try {
            MemberProperty param = new MemberProperty();
            param.setName(name);
            param.setUserId(usedId);

            if (memberPropertyDao.getListBy(param).size() == 0){
                MemberProperty memberJob = MemberProperty.generateNewMemberProperty(name, usedId);
                memberPropertyDao.addOne(memberJob);
            }
            return true;
        } catch (Exception e) {
            log.error("addMemberProperty failed", e);
            return false;
        }
    }


    public boolean deleteMemberProperty(long id) {
        try {
            if (memberPropertyDao.delOne(id) > 0) {
                return true;
            }
        } catch (Exception e) {
            log.error("deleteMemberProperty failed", e);
            return false;
        }
        return false;
    }

    public List<MemberProperty> getListByUserId(long userId){
        try {
            return memberPropertyDao.getListByUserId(userId);
        } catch (Exception e) {
            log.error("getListByUserId failed", e);
            return null;
        }
    }

}
