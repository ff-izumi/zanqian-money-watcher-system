package com.lazyan.antechou;

import com.lazyan.antechou.service.BillService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class BillTest extends ApplicationTests {
    @Autowired BillService billService;

    @Test
    public void test1(){
        int uid = 10;
        List<HashMap> obj = (List<HashMap>) billService.findAllByUid(uid);
        System.out.println(obj);
    }
}
