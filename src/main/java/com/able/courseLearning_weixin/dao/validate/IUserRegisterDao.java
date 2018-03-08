package com.able.courseLearning_weixin.dao.validate;

import com.able.courseLearning_weixin.common.pojo.AllUser;

public interface IUserRegisterDao {
    //申请信息存入表tbl_user
    Integer insertUser(AllUser user);
    //通过openId判断是tbl_user是否有该学生
    Integer selectUserByOpenId(String openId);
}
