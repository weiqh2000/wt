package com.bs.wt.backstage.web.back;

import static org.junit.jupiter.api.Assertions.*;
import com.bs.wt.backstage.bean.Admin;
import com.bs.wt.backstage.bean.QueryInfo;
import com.bs.wt.backstage.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class AdminControllerTest {
    @Autowired
    AdminController adminController;

    @Test
    void testQuery(){
        QueryInfo queryInfo = new QueryInfo();
        System.out.println(queryInfo);
        System.out.println(adminController.adminManage(queryInfo));

    }

//    @Test
//    void testupdateRole(){
//        System.out.println(adminController.updateRole("wt", false));
//    }

    @Test
    void testUpdateAdmin(){
        Admin admin = new Admin();
        admin.setName("nio发asdf80");
        admin.setPassword("wqefIOUN789");
        admin.setUsername("rvt");
//        System.out.println(adminController.updateAdmin(admin));
    }
}