package com.zanqian.modules.service.app.impl;

import com.zanqian.modules.service.app.UserService;
import com.zanqian.modules.entity.app.User;
import com.zanqian.modules.mapper.app.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GanQuan
 * @since 2025-05-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
