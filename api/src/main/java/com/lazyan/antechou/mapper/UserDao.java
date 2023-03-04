package com.lazyan.antechou.mapper;

import com.lazyan.antechou.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {

    //插入用户
    @Insert("INSERT INTO user(username,birthday,gender,introduction,aid) VALUES (#{username},#{birthday},#{gender},#{introduction},#{aid})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(User user);

    //根据邮箱查询用户信息
    @Select("SELECT * FROM user WHERE aid =(SELECT id FROM account WHERE mailbox = #{mailbox})")
    User findUserByMailbox(@Param("mailbox") String mailbox);

    //根据邮箱查询用户id
    @Select("SELECT id FROM user WHERE aid =(SELECT id FROM account WHERE mailbox = #{mailbox})")
    int findUidByMailbox(@Param("mailbox") String mailbox);

    //根据id修改用户信息
    @Update("UPDATE user SET username = #{username},birthday = #{birthday},gender = #{gender}, introduction = #{introduction} WHERE id = #{id}")
    void updateUser(User user);
}
