package com.lazyan.antechou.mapper;

import com.lazyan.antechou.pojo.Tlist;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TlistDao {
    //根据用户id查询用户所有的账单信息
    @Select("SELECT l.id, l.in_ex,l.amount,t.type,l.remarks,l.datetime FROM tlist l INNER JOIN ttype t ON l.tid = t.id  WHERE l.uid = #{uid};")
    List<HashMap> findAllByUid(@Param("uid") int uid);

    //新增一条新的账单信息
    @Insert("INSERT INTO tlist(uid,in_ex,amount,tid,remarks,datetime) VALUES (#{uid},#{in_ex},#{amount},#{tid},#{remarks},#{datetime});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertNewTlist(Tlist tlist);

    //修改一条根据id修改一条数据
    @Update("UPDATE tlist SET uid = #{uid},in_ex = #{in_ex},amount = #{amount}, remarks = #{remarks},datetime=#{datetime} WHERE id = #{id};")
    void updateTlistById(Tlist tlist);

    //根据id删除一条数据
    @Delete("DELETE FROM tlist WHERE id = #{id}")
    void deleteTlistByid(@Param("id") int id);
}
