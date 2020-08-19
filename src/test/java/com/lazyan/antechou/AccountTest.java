package com.lazyan.antechou;

import com.lazyan.antechou.pojo.Account;
import com.lazyan.antechou.pojo.User;
import com.lazyan.antechou.service.LoginService;
import com.lazyan.antechou.service.RegisterService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountTest extends ApplicationTests{
    @Autowired RegisterService registerService;
    @Autowired LoginService loginService;
    @Test
    public void insertAccountTest(){
        Account account = new Account();
        account.setMailbox("test1");
        account.setPassword("123456");
        registerService.insertAccount(account);
    }

    @Test
    public void insertUserTest(){
        Account account = new Account();
        account.setMailbox("test1");
        Account account_one =  registerService.findAccountByMailbox(account.getMailbox());
        int aid = account_one.getId();
        User user = new User();
        user.setAid(aid);
        user.setUsername("测试1");
        user.setBirthday("2020-01-01");
        user.setGender("男");
        user.setIntroduction("无");
        registerService.insertUser(user);
    }
    @Test
    public void loginTest(){
        String mailbox = "test1";
        String password = "123457";
        User user = loginService.findUserByMailbox(mailbox);
        System.out.println(user);
        System.out.println(loginService.isExist(mailbox,password));

    }
}
