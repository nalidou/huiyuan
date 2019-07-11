package com.jujingyun.huiyuan.dao;

import com.jujingyun.huiyuan.common.entity.Member;

import java.util.List;

public interface MemberDao {

    int addOne(Member member);

    int updateOne(Member member);

    int updateIsDelete(long id, int isDelete);

    List<Member> getListBy(Member member);





}
