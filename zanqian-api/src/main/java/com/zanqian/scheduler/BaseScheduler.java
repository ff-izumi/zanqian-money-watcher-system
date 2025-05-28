package com.zanqian.scheduler;

import com.zanqian.modules.service.app.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author GanQuan
 * @date 2025-05-28 16:56
 */
@Slf4j
@Component
public class BaseScheduler {

    @Resource
    public AuthService authService;

    @Scheduled(cron = "0 0 0/2 * * ? ")
//    @Scheduled(cron = "0/5 * * * * ?")
    public void refreshAuthKey () {
        authService.refreshAuthAppKey();
        authService.refreshAuthSysKey();
    }


}
