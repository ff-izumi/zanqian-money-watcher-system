package com.lazyan.antechou.mapper;

import com.lazyan.antechou.pojo.Ttype;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TtypeDao {

    //根据用户id查询所有分类
    @Select("SELECT id,type FROM ttype WHERE uid = #{uid};")
    List<HashMap> findAllTypeByUid(@Param("uid") int uid);

    //新增一个新分类
    @Insert("INSERT INTO ttype(type,uid) VALUES (#{type},#{uid});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertNewTtype(Ttype ttype);

    //修改一个分类
    @Update("UPDATE ttype SET type = #{type}, uid = #{uid} WHERE id = #{id};")
    void updateTtypeByid(Ttype ttype);

    //根据id删除一条数据
    @Delete("DELETE FROM ttype WHERE id = #{id}")
    void deleteTtypeByid(@Param("id") int id);

    //查询用户分类的总数
    @Select("SELECT count(*) FROM ttype WHERE uid = #{uid}")
    int countTypeByUid(@Param("uid") int uid);
}
