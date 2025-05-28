package com.zanqian.modules.service.app.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.zanqian.common.constant.redisConstant;
import com.zanqian.common.util.RedisUtils;
import com.zanqian.modules.service.app.AuthService;
import org.springframework.stereotype.Service;

import java.util.HashMap;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GanQuan
 * @since 2025-05-21
 */
@Service
public class AuthServiceImpl implements AuthService {

    private final long expire = 2 * 60 * 60;

    @Override
    public void refreshAuthAppKey() {
        try {
            HashMap<String, String> appKeyPair = SaSecureUtil.rsaGenerateKeyPair();
            RedisUtils.set(redisConstant.AUTH_APP_PUBLIC_KEY, appKeyPair.get("public"), expire);
            RedisUtils.set(redisConstant.AUTH_APP_PRIVATE_KEY, appKeyPair.get("private"), expire);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void refreshAuthSysKey() {
        try {
            HashMap<String, String> appKeyPair = SaSecureUtil.rsaGenerateKeyPair();
            RedisUtils.set(redisConstant.AUTH_SYS_PUBLIC_KEY, appKeyPair.get("public"), expire);
            RedisUtils.set(redisConstant.AUTH_SYS_PRIVATE_KEY, appKeyPair.get("private"), expire);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
