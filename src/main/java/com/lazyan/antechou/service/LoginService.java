package com.lazyan.antechou.service;

import com.lazyan.antechou.mapper.AccountDao;
import com.lazyan.antechou.mapper.IpDao;
import com.lazyan.antechou.mapper.UserDao;
import com.lazyan.antechou.pojo.Account;
import com.lazyan.antechou.pojo.Ip;
import com.lazyan.antechou.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired AccountDao accountDao;
    @Autowired UserDao userDao;
    @Autowired IpDao ipDao;

    public boolean isExist(String mailbox,String password ){
        Account account= accountDao.findAccountByMailboxAndPassword(mailbox,password);
        return null!=account;
    }

    public void addIp(String mailbox,String lost_ip){
        accountDao.updateAccountLost_ip(mailbox,lost_ip);
    }

    public User findUserByMailbox(String mailbox){
        User user = userDao.findUserByMailbox(mailbox);
        return user;
    }

    public int findAidByMailbox (String mailbox){
        int aid =  accountDao.findAidByMailbox(mailbox);
        return aid;
    }

    public int findUidByMailbox (String mailbox){
        int uid =  userDao.findUidByMailbox(mailbox);
        return uid;
    }

    public void insertIp(Ip ip){
        ipDao.insertIp(ip);
    }
}
