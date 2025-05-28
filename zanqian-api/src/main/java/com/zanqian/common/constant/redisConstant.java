package com.zanqian.common.constant;

/**
 * Redis key
 *
 * @author GanQuan
 * @date 2025-05-28 12:16
 */
public class redisConstant {

    public static final String prefix = "zanqian:";

    /**
     * APP 公钥
     */
    public static final String AUTH_APP_PUBLIC_KEY = prefix + "auth:app:publicKey";

    /**
     * APP 私钥
     */
    public static final String AUTH_APP_PRIVATE_KEY = prefix + "auth:app:privateKey";

    /**
     * SYS 公钥
     */
    public static final String AUTH_SYS_PUBLIC_KEY = prefix + "auth:sys:publicKey";

    /**
     * SYS 私钥
     */
    public static final String AUTH_SYS_PRIVATE_KEY = prefix + "auth:sys:privateKey";

}
