package com.lazyan.antechou.mapper;

import com.lazyan.antechou.pojo.Ip;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;


@Mapper
public interface IpDao {
    //根据邮箱插入IP
    @Insert("INSERT INTO ip(ip,datetime,aid,uid) VALUES (#{ip},#{datetime},#{aid},#{uid})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertIp(Ip ip);

    //查询所有ip表所有的aid
    @Select("SELECT DISTINCT aid FROM ip")
    ArrayList<Integer> selectIpAid();

    //查询ip表里一个账号的所有ip记录的id
    @Select("SElECT id FROM ip WHERE  aid = #{aid} ORDER BY datetime DESC")
    ArrayList<Integer> selectIpId(@Param("aid") int aid);

    //根据id删除ip记录
    @Delete("DELETE FROM ip WHERE id = #{id}")
    void deleteIpById(@Param("id") int id);
}
