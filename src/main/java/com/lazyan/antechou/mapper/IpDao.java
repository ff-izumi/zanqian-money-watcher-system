package com.lazyan.antechou.mapper;


import com.lazyan.antechou.pojo.Ip;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface IpDao {
    //根据邮箱插入IP
    @Insert("INSERT INTO ip(ip,aid,uid) VALUES (#{ip},#{aid},#{uid})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertIp(Ip ip);
}
