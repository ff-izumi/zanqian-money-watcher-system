package com.lazyan.antechou.util;

import com.lazyan.antechou.service.IpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class ScheduledTaskIp {
    @Autowired IpService ipService;

    @Scheduled(fixedRate = 86400000)
    public void scheduledTask() {
        ArrayList<Integer> aid_list = ipService.selectIpAid();
        for (int i = 0; i < aid_list.size(); i++) {
            ArrayList<Integer> id_list = ipService.selectIpId(aid_list.get(i));
            if(10<id_list.size()){
                ArrayList<Integer> newidlist =  new ArrayList<Integer>();
                for(int j = 0;j < 10; j++){
                    newidlist.add(id_list.get(j));
                }
                id_list.removeAll(newidlist);
                for (int k= 0; k < id_list.size(); k++) {
                    ipService.deleteIpById(id_list.get(k));
                }
                System.out.println("任务执行时间：" + LocalDateTime.now());
            }else{
                System.out.println("任务无需清理");
            }
        }

    }
}
