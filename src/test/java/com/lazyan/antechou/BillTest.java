package com.lazyan.antechou;

import com.lazyan.antechou.pojo.Ttype;
import com.lazyan.antechou.service.BillService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static java.util.Arrays.asList;

public class BillTest extends ApplicationTests {
    @Autowired BillService billService;

    @Test
    public void test1(){
        int uid = 10;
        List<HashMap> obj = (List<HashMap>) billService.findAllByUid(uid);
        System.out.println(obj);
    }

    @Test
    public void test2(){
        List<String> types = asList("三餐", "娱乐", "日用");
        for (int i = 0;i< types.size();i++){
            Ttype ttype = new Ttype();
            ttype.setType(types.get(i));
            ttype.setUid(1);
            //billService.insertNewTtype(ttype);
        }
    }
}
