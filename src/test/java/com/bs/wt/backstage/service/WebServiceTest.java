package com.bs.wt.backstage.service;

import com.bs.wt.backstage.bean.phoenix.AllPhoenixBean;
import com.bs.wt.backstage.bean.phoenix.QueryWebInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
class WebServiceTest {
    @Autowired
    WebService webService;

    @Test
    void testQueryBusiness(){
        QueryWebInfo queryWebInfo = new QueryWebInfo();
        Map<String, Object> map=new HashMap<String, Object>();
        System.out.println(queryWebInfo.getTitle());

        map.put("data", webService.queryBusiness(queryWebInfo));
        System.out.println(map);

    }
}