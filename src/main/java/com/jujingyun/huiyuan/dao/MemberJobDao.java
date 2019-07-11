package com.jujingyun.huiyuan.dao;

import com.jujingyun.huiyuan.common.entity.MemberJob;

import java.util.List;

public interface MemberJobDao {

    int addOne(MemberJob memberJob);

    int delOne(long id);

    List<MemberJob> getListByUserId(long userId);

}
