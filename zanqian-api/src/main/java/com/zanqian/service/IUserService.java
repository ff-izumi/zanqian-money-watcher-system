package com.zanqian.service;

import com.zanqian.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ganquan
 * @since 2023-04-28
 */
public interface IUserService extends BaseService<User> {

    Boolean login();

}
