package com.lazyan.antechou.web;

import com.lazyan.antechou.pojo.Account;
import com.lazyan.antechou.pojo.Ip;
import com.lazyan.antechou.pojo.User;
import com.lazyan.antechou.service.LoginService;
import com.lazyan.antechou.util.IpDateTime;
import com.lazyan.antechou.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
public class LoginController {
    @Autowired LoginService loginService;

    @PostMapping("addlogin")
    public Object addlogin(@RequestBody Account account, HttpSession session) {
        String mailbox = account.getMailbox();
        String password = account.getPassword();
        String lost_ip = account.getLost_ip();
        boolean exist = loginService.isExist(mailbox,password);
        Ip login_ip = new Ip();
        String login_time = IpDateTime.IpDateTime();
        login_ip.setIp(lost_ip);
        login_ip.setDatetime(login_time);
        login_ip.setAid(loginService.findAidByMailbox(mailbox));
        login_ip.setUid(loginService.findUidByMailbox(mailbox));
        if(exist){
            loginService.addIp(mailbox,lost_ip);
            User user = loginService.findUserByMailbox(mailbox);
            loginService.insertIp(login_ip);
            session.setAttribute("user", user);
            return Result.success();
        }else{
            String message ="账号密码错误";
            return Result.fail(message);
        }
    }

}