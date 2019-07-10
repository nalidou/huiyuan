package com.jujingyun.huiyuan.common.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * 会员实体类
 */
public class Member extends AbstractEntity{

    private String name;//姓名
    private int sex; //性别 1：男，2：女
    private int age;//年龄
    private String nation;//民族
    private String eduBackground; //学历
    private String nativeAddress; //籍贯
    private String birthday;//生日
    private String idCard;//身份证号
    private String mobilephone;//手机
    private String telephone;//电话
    private String email;//邮箱
    private String homeAdderss;//家庭地址

    private String companyName;//企业信息
    private String companyJob;//企业职务
    private String companyAddress;//公司地址
    private int companyStatus;//职务状态

    private String memberName;//所在商会
    private String memberJob;//商会职务
    private String memberProperty;//商会性质
    private long memberEnterDate;//入会时间
    private String memberReferrer;//推荐人
    private int memberStatus;//会费状态

    private int isQuit;//退会标识 0：退，1：未退
    private String memo;//备注
    private String operaRecord;//操作记录

    private String info;//其他信息（创建时间等）
    private int isDelete;// 删除标记 0：删除， 1：未删

    @Override
    public JSONObject toJSONObject() {
        return null;
    }
}
