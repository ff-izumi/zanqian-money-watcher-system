package com.zanqian.controller;

import com.zanqian.common.result.Result;
import com.zanqian.service.IUserService;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Author GanQuan
 * @Date 2023-04-28 15:47
 **/
@ControllerAdvice
@RequestMapping("v1/api")
public class BaseController {

    @Resource
    private IUserService userService;

    @PostMapping("login")
    public Result<Boolean> login(){

        Result<Boolean> res = Result.success();
        return res;
    }

}
