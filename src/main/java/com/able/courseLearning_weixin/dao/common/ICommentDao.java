package com.able.courseLearning_weixin.dao.common;

import com.able.courseLearning_weixin.common.dto.CommentDto;

import java.util.List;

public interface ICommentDao {
    //老师创建讨论话题
    Integer insertComment(Integer classId,String title,String Name);
    //查找话题下的所有讨论
    List<CommentDto> findCommentDetailList(Integer commentId);
    //得到班级下的所有评论论题
    List<CommentDto> findCommentlistByClassId(Integer classId);
    //学生评论话题
    Integer studentInsertComment(String comment,String openId,Integer commentId);
}
