package com.lazyan.antechou.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/registerSuccess")
    public String registerSuccess(){
        return "registerSuccess";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index")
    public String index(HttpSession session){
        Object Login = session.getAttribute("user");
        if (Login == null){
            return "login";
        }else {
            return "index";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }

    @GetMapping("/useredit")
    public String useredit(HttpSession session){
        Object Login = session.getAttribute("user");
        if (Login == null){
            return "login";
        }else {
            return "useredit";
        }
    }

    @GetMapping("/addbill")
    public String addbill(HttpSession session){
        Object Login = session.getAttribute("user");
        if (Login == null){
            return "login";
        }else {
            return "addbill";
        }
    }
    @GetMapping("/bill_list_edit")
    public String billedit(HttpSession session){
        Object Login = session.getAttribute("user");
        if (Login == null){
            return "login";
        }else {
            return "editbill";
        }
    }
    @GetMapping("/type")
    public String type(HttpSession session){
        Object Login = session.getAttribute("user");
        if (Login == null){
            return "login";
        }else {
            return "type";
        }
    }
    @GetMapping("/type_list_edit")
    public String typeedit(HttpSession session){
        Object Login = session.getAttribute("user");
        if (Login == null){
            return "login";
        }else {
            return "edittype";
        }
    }
}