package com.zanqian.service.impl;

import com.zanqian.entity.User;
import com.zanqian.mapper.UserMapper;
import com.zanqian.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ganquan
 * @since 2023-04-28
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {

}
