package com.lazyan.antechou.web;

import com.lazyan.antechou.pojo.Tlist;
import com.lazyan.antechou.pojo.User;
import com.lazyan.antechou.service.BillService;
import com.lazyan.antechou.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class BillController {
    @Autowired BillService billService;

    @GetMapping("/billes")
    public Object index( HttpSession session){
        Object login = session.getAttribute("user");
        User user = (User) login;
        int uid = user.getId();
        Object obj =  billService.findAllByUid(uid);
        return obj;
    }

    @GetMapping("/ttypelist")
    public Object ttypelist( HttpSession session){
        Object login = session.getAttribute("user");
        User user = (User) login;
        int uid = user.getId();
        Object obj =  billService.findAllTypeByUid(uid);
        return obj;
    }
    @PostMapping("/addtlist")
    public Object addbill(@RequestBody Tlist tlist,HttpSession session){
        Object login = session.getAttribute("user");
        User user = (User) login;
        int uid = user.getId();
        tlist.setUid(uid);
        billService.insertNewTlist(tlist);
        return Result.success();
    }
}
