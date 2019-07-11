package com.jujingyun.huiyuan.dao;

import com.jujingyun.huiyuan.common.entity.MemberProperty;

import java.util.List;

public interface MemberPropertyDao {

    int addOne(MemberProperty memberJob);

    int delOne(long id);

    List<MemberProperty> getListByUserId(long userId);
}
