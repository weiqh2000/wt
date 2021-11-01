package com.bs.wt.backstage.service;

import com.bs.wt.backstage.bean.Admin;
import com.bs.wt.backstage.bean.QueryInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class AdminServiceTest {
    @Autowired
    AdminService adminService;

    @Test
    void query() {
        QueryInfo info = new QueryInfo();
        info.setPageSize(5);
        System.out.println(info.getQuery());
        System.out.println(info.getPageNum());
        System.out.println(info.getPageNum());
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("data", adminService.query(info));
        System.out.println();
        System.out.println(map);
    }

    @Test
    void testAdd(){
        Admin admin = new Admin();
        admin.setUsername("sssddf");
        admin.setName("asdf");
        admin.setCreateTime(Calendar.getInstance().getTime());
        admin.setRole(1);
        admin.setPassword("156156");
        System.out.println(admin);
        System.out.println(adminService.add(admin));
    }

    @Test
    void testUpdate(){
        Admin admin = new Admin();
        admin.setUsername("rvt");
        admin.setName("rvt");
        admin.setPassword("dddddddddddd");
        admin.setRole(1);
        System.out.println(adminService.update(admin));
    }

    @Test
    void testGetEditAdmin(){
        System.out.println(adminService.getEditAdmin("weiqh"));
    }
}