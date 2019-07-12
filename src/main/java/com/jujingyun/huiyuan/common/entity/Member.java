package com.jujingyun.huiyuan.common.entity;

import com.alibaba.fastjson.JSONObject;
import com.jujingyun.huiyuan.common.util.TimeUtil;

import java.text.ParseException;

/**
 * 会员实体类
 */
public class Member extends AbstractEntity{

    private String name = "";//姓名
    private int sex = 0; //性别 1：男，2：女
    private int age = 0;//年龄
    private String nation = "";//民族
    private String eduBackground = ""; //学历
    private String nativeAddress = ""; //籍贯
    private String birthday = "";//生日
    private String idCard = "";//身份证号
    private String mobilephone = "";//手机
    private String telephone = "";//电话
    private String email = "";//邮箱
    private String homeAdderss = "";//家庭地址

    private String companyName = "";//企业信息
    private String companyJob = "";//企业职务
    private String companyAddress = "";//公司地址
    private int companyStatus = 0;//职务状态 1：在职，2：离职，3：退休

    private String memberName = "";//所在商会
    private String memberJob = "";//商会职务
    private String memberProperty = "";//商会性质
    private long memberEnterDate = 0L;//入会时间
    private String memberReferrer = "";//推荐人
    private int memberStatus = 0;//会费状态 1：未交费，2：已交费

    private int isQuit = 0;//退会标识 1：退，2：未退
    private String memo = "";//备注
    private String operaRecord = "";//操作记录,操作的人

    private int isDelete = 1;// 删除标记 0：删除，1：未删
    private long userId = 0L;//所属用户ID

    private long startTime = 0L;
    private long endTime = 0L;
    private int pageIndex = 1;
    private int pageSize = 10;

    public Member(){}

    public static Member generateNewMember(Member member, long userId){
        member.setUserId(userId);
        member.setCreateTime(System.currentTimeMillis());
        return member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public String getSexStr() {
        return sex == 1 ? "男" : sex == 2 ? "女" : "未知";
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getEduBackground() {
        return eduBackground;
    }

    public void setEduBackground(String eduBackground) {
        this.eduBackground = eduBackground;
    }

    public String getNativeAddress() {
        return nativeAddress;
    }

    public void setNativeAddress(String nativeAddress) {
        this.nativeAddress = nativeAddress;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAdderss() {
        return homeAdderss;
    }

    public void setHomeAdderss(String homeAdderss) {
        this.homeAdderss = homeAdderss;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyJob() {
        return companyJob;
    }

    public void setCompanyJob(String companyJob) {
        this.companyJob = companyJob;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public int getCompanyStatus() {
        return companyStatus;
    }

    public String getCompanyStatusStr() {
        if (companyStatus == 1) {
            return "在职";
        } else if (companyStatus == 2) {
            return "离职";
        } else if (companyStatus == 3){
            return "退休";
        } else {
            return "未知";
        }
    }

    public void setCompanyStatus(int companyStatus) {
        this.companyStatus = companyStatus;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberJob() {
        return memberJob;
    }

    public void setMemberJob(String memberJob) {
        this.memberJob = memberJob;
    }

    public String getMemberProperty() {
        return memberProperty;
    }

    public void setMemberProperty(String memberProperty) {
        this.memberProperty = memberProperty;
    }

    public long getMemberEnterDate() {
        return memberEnterDate;
    }

    public String getMemberEnterDateStr() {
        return TimeUtil.time2DateStr(memberEnterDate);
    }

    public void setMemberEnterDate(long memberEnterDate) {
        this.memberEnterDate = memberEnterDate;
    }

    public void setMemberEnterDate(String memberEnterDate) throws ParseException {
        this.memberEnterDate = TimeUtil.dateStr2Time(memberEnterDate);
    }

    public String getMemberReferrer() {
        return memberReferrer;
    }

    public void setMemberReferrer(String memberReferrer) {
        this.memberReferrer = memberReferrer;
    }

    public int getMemberStatus() {
        return memberStatus;
    }

    public String getMemberStatusStr() {
        if (memberStatus == 1) {
            return "未交费";
        } else if (memberStatus == 2) {
            return "已交费";
        } else {
            return "未知";
        }
    }

    public void setMemberStatus(int memberStatus) {
        this.memberStatus = memberStatus;
    }

    public int getIsQuit() {
        return isQuit;
    }

    public String getIsQuitStr() {
        if (isQuit == 1) {
            return "退";
        } else if (isQuit == 2){
            return "未退";
        } else {
            return "未知";
        }
    }

    public void setIsQuit(int isQuit) {
        this.isQuit = isQuit;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOperaRecord() {
        return operaRecord;
    }

    public void setOperaRecord(String operaRecord) {
        this.operaRecord = operaRecord;
    }


    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getPageIndex() {
        int newPageIndex = 0;
        if (pageIndex == 1) {
            newPageIndex = 0;
        } else if (pageIndex > 1) {
            newPageIndex = (pageIndex - 1) * pageSize;
        }
        return newPageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        json.put("id", getId());
        json.put("name", getName());
        json.put("sex", getSex());
        json.put("sexStr", getSexStr());
        json.put("age", getAge());
        json.put("nation", getNation());
        json.put("eduBackground", getEduBackground());
        json.put("nativeAddress", getNativeAddress());
        json.put("birthday", getBirthday());
        json.put("idCard", getIdCard());
        json.put("mobilephone", getMobilephone());
        json.put("telephone", getTelephone());
        json.put("email", getEmail());
        json.put("homeAdderss", getHomeAdderss());

        json.put("companyName", getCompanyName());
        json.put("companyJob", getCompanyJob());
        json.put("companyAddress", getCompanyAddress());
        json.put("companyStatus", getCompanyStatus());
        json.put("companyStatusStr", getCompanyStatusStr());

        json.put("memberName", getMemberName());
        json.put("memberJob", getMemberJob());
        json.put("memberProperty", getMemberProperty());
        json.put("memberEnterDate", getMemberEnterDate());
        json.put("memberEnterDateStr", getMemberEnterDateStr());
        json.put("memberReferrer", getMemberReferrer());
        json.put("memberStatus", getMemberStatus());
        json.put("memberStatusStr", getMemberStatusStr());

        json.put("isQuit", getIsQuit());
        json.put("isQuitStr", getIsQuitStr());
        json.put("memo", getMemo());
        json.put("operaRecord", getOperaRecord());

        return json;
    }
}
