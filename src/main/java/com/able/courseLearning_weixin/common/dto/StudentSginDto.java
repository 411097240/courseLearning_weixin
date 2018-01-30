package com.able.courseLearning_weixin.common.dto;

import java.io.Serializable;
import java.util.Date;

public class StudentSginDto implements Serializable{
    private String className;//课程名称
    private String schoolCode;//学生学号
    private String realName;//学生姓名
    private Date createTime;//签到时间
    private String sginTime;//前端显示的签到时间
    private String longitude;//经度
    private String latitude;//纬度
    private String headImgUrl;//用户头像

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSginTime() {
        return sginTime;
    }

    public void setSginTime(String sginTime) {
        this.sginTime = sginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }
}
