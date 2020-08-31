package com.lazyan.antechou.web;

import com.lazyan.antechou.pojo.Tlist;
import com.lazyan.antechou.pojo.Ttype;
import com.lazyan.antechou.pojo.User;
import com.lazyan.antechou.service.BillService;
import com.lazyan.antechou.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class BillController {
    @Autowired BillService billService;

    @GetMapping("/billes")
    public Object index( HttpSession session) {
        Object login = session.getAttribute("user");
        User user = (User) login;
        int uid = user.getId();
        Object obj =  billService.findAllByUid(uid);
        int tcount = billService.countTypeByUid(uid);
        if (tcount == 0){
            autoAddType(uid);
            return obj;
        }else {
            return obj;
        }
    }

    @GetMapping("/addtlist")
    public Object addtlistType( HttpSession session){
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
    @DeleteMapping("/billes/{id}")
    public String deletebille(@PathVariable("id") int id){
        billService.deleteTlistByid(id);
        return null;
    }
    @GetMapping("/updatetlist")
    public Object updatetlistType( HttpSession session){
        Object login = session.getAttribute("user");
        User user = (User) login;
        int uid = user.getId();
        Object obj =  billService.findAllTypeByUid(uid);
        return obj;
    }
    @PutMapping("/updatetlist/{id}")
    public Object updatebill(@PathVariable("id") int id,@RequestBody Tlist tlist,HttpSession session){
        Object login = session.getAttribute("user");
        User user = (User) login;
        int uid = user.getId();
        tlist.setUid(uid);
        tlist.setId(id);
        billService.updateTlistById(tlist);
        return Result.success();
    }
    @GetMapping("/types")
    public Object types(HttpSession session){
        Object login = session.getAttribute("user");
        User user = (User) login;
        int uid = user.getId();
        Object obj =  billService.findAllTypeByUid(uid);
        return obj;
    }
    @PostMapping("/types")
    public Object addType(@RequestBody Ttype ttype,HttpSession session){
        Object login = session.getAttribute("user");
        User user = (User) login;
        int uid = user.getId();
        ttype.setUid(uid);
        billService.insertNewTtype(ttype);
        return Result.success();
    }
    @PutMapping("/updatetype/{id}")
    public Object updatetype(@PathVariable("id") int id,@RequestBody Ttype ttype,HttpSession session){
        Object login = session.getAttribute("user");
        User user = (User) login;
        int uid = user.getId();
        ttype.setUid(uid);
        ttype.setId(id);
        billService.updateTtypeByid(ttype);
        return Result.success();
    }
    @DeleteMapping("/types/{id}")
    public String deletetype(@PathVariable("id") int id){
        billService.deleteTtypeByid(id);
        return null;
    }

    public void autoAddType(int uid){
        List<String> types = new ArrayList<>(Arrays.asList("三餐", "娱乐", "日用"));
        for (int i = 0;i< types.size();i++){
            Ttype ttype = new Ttype();
            ttype.setType(types.get(i));
            ttype.setUid(uid);
            billService.insertNewTtype(ttype);
        }
    }
}
