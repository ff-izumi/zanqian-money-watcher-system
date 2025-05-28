package com.zanqian.modules.controller.app;

import com.zanqian.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author GanQuan
 * @date 2023-04-28 15:47
 **/
@ControllerAdvice
@RequestMapping("api/app/login")
public class LoginController {

    @PostMapping("account")
    public Result<Boolean> login(){

        Result<Boolean> res = Result.success();
        return res;
    }

}
