package com.bs.wt.backstage.dao.phoenix;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bs.wt.backstage.bean.phoenix.AllPhoenixBean;

import java.util.List;


@SpringBootTest
class TestPhoenixTest {
    @Autowired
    MyTestPhoenix myTestPhoenix;


    @Test
    void  testgettest6() {
        List<AllPhoenixBean> all = myTestPhoenix.gettest6();
        for(AllPhoenixBean i:all){
            System.out.println(i);
        }
    }


}