package com.lazyan.antechou.web;

import com.lazyan.antechou.pojo.User;
import com.lazyan.antechou.service.UsereditService;
import com.lazyan.antechou.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UsereditController {
    @Autowired UsereditService usereditService;

    @PostMapping("/useredit")
    public Object useredit(@RequestBody User user, HttpSession session){
        Object obj = session.getAttribute("user");
        User suser = (User)obj;
        user.setId(suser.getId());
        usereditService.updateUser(user);
        return Result.success();
    }
}
