package com.lazyan.antechou.service;

import com.lazyan.antechou.mapper.UserDao;
import com.lazyan.antechou.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsereditService {
    @Autowired UserDao userDao;

    public void updateUser(User user){
        userDao.updateUser(user);
    }
}
