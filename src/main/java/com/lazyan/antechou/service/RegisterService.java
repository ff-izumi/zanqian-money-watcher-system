package com.lazyan.antechou.service;

import com.lazyan.antechou.mapper.AccountDao;
import com.lazyan.antechou.mapper.UserDao;
import com.lazyan.antechou.pojo.Account;
import com.lazyan.antechou.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired AccountDao accountDao;
    @Autowired UserDao userDao;

    public boolean isExist(String name) {
        Account account = findAccountByMailbox(name);
        return null!=account;
    }

    public void insertAccount(Account account){
        accountDao.insertAccount(account);
    }

    public void insertUser(User user){
        userDao.insertUser(user);
    }

    public Account findAccountByMailbox (String mailbox){
        Account account =  accountDao.findAccountMailboxByMailbox(mailbox);
        return account;
    }

    public int findAidByMailbox (String mailbox){
        int aid =  accountDao.findAidByMailbox(mailbox);
        return aid;
    }

}
