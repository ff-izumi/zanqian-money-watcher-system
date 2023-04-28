package com.zanqian.mapper;

import com.zanqian.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ganquan
 * @since 2023-04-28
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
