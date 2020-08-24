package com.lazyan.antechou.service;

import com.lazyan.antechou.mapper.IpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class IpService {
    @Autowired IpDao ipDao;

    public ArrayList<Integer> selectIpAid(){
        return ipDao.selectIpAid();
    }

    public ArrayList<Integer> selectIpId(int aid){
        return ipDao.selectIpId(aid);
    }

    public void deleteIpById(int id){
        ipDao.deleteIpById(id);
    }
}
