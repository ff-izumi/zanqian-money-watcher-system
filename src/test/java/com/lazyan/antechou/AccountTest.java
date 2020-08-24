package com.lazyan.antechou;

import com.lazyan.antechou.mapper.IpDao;
import com.lazyan.antechou.pojo.Account;
import com.lazyan.antechou.pojo.User;
import com.lazyan.antechou.service.IpService;
import com.lazyan.antechou.service.LoginService;
import com.lazyan.antechou.service.RegisterService;
import com.lazyan.antechou.util.IpDateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class AccountTest extends ApplicationTests{
    @Autowired RegisterService registerService;
    @Autowired LoginService loginService;
    @Autowired IpService ipService;

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

    @Test
    public void dateTest(){
        String date = IpDateTime.IpDateTime();
        System.out.println(date);
    }

    @Test
    public void sqlIpTest(){
        ArrayList<Integer> list_1 = ipService.selectIpAid();
        for (int i = 0; i < list_1.size(); i++) {
            System.out.println(list_1.get(i));
        }

        ArrayList<Integer> list_2 = ipService.selectIpId(2);
        for (int i = 0; i < list_2.size(); i++) {
            System.out.println(list_2.get(i));
        }
    }
}
