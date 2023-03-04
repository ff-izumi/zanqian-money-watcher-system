package com.lazyan.antechou.web;

import com.lazyan.antechou.pojo.Account;
import com.lazyan.antechou.pojo.User;
import com.lazyan.antechou.service.RegisterService;
import com.lazyan.antechou.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RegisterController {

    @Autowired RegisterService registerService;

    @PostMapping("/addregister")
    public Object addregister(@RequestBody Account account){
        String mailbox = account.getMailbox();
        String password = account.getPassword();
        boolean exist = registerService.isExist(mailbox);
        if(exist){
            String message ="用户名已经被使用,不能使用";
            return Result.fail(message);
        }
        account.setPassword(password);

        registerService.insertAccount(account);

        int aid = registerService.findAidByMailbox(mailbox);
        //(#{username},#{birthday},#{gender},#{introduction},#{aid})"
        String code="";
        Random rand=new Random();//生成随机数
        for(int a=0;a<6;a++){
            code+=rand.nextInt(10);//生成6位验证码
        }
        String username = "用户" +code;
        User user = new User();
        user.setUsername(username);
        user.setBirthday("1900-01-01");
        user.setGender("保密");
        user.setIntroduction("这个人懒死了没有签名");
        user.setAid(aid);

        registerService.insertUser(user);

        return Result.success();
    }
}