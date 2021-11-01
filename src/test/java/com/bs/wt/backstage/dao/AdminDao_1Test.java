package com.bs.wt.backstage.dao;

import com.bs.wt.backstage.bean.Admin;
import com.bs.wt.backstage.bean.QueryInfo;
import com.bs.wt.backstage.dao.mysql.AdminDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.List;


@SpringBootTest
class AdminDao_1Test {

    @Autowired
    AdminDao adminDao;

    @Test
    void  testGetAdminList(){
        QueryInfo queryInfo = new QueryInfo();
        List<Admin> list = adminDao.getAdminList("%" + queryInfo.getQuery() + "%", queryInfo.getPageNum(),queryInfo.getPageSize());
        for(Admin admin:list){
            System.out.println(admin);
        }
    }

    @Test
    void testGetAdminCounts(){
        int i = adminDao.getAdminCounts("%w%");
        System.out.println(i);
    }

    @Test
    void testUpdateAdminRole(){
        System.out.println(adminDao.updateRole("wt", true));

    }


    @Test
    void  testAddAdmin(){
        System.out.println(adminDao.getAddAdmin("wt"));
    }

    @Test
    void  testSave(){
        Admin admin = new Admin();
        admin.setUsername("sadasd");
        admin.setName("asdf");
        admin.setCreateTime(Calendar.getInstance().getTime());
        admin.setRole(1);
        admin.setPassword("156156");
        System.out.println(admin);
        System.out.println(adminDao.save(admin.getUsername(),
                admin.getPassword(),
                admin.getName(),
                admin.getRole(),
                admin.getCreateTime()));
    }

    @Test
    void testDele(){
        System.out.println(adminDao.deleteAdmin("2"));
    }

    @Test
    void testUpdateAdmin(){
        Admin admin =new Admin();
        admin.setUsername("rvt");
        admin.setPassword("hnuinui");
        admin.setName("opopop");
        System.out.println(adminDao.updateAdmin(admin));
    }

    @Test
    void testAdminPassword(){
        Admin admin =new Admin();
        admin.setUsername("rvt");
        admin.setPassword("hnuinui");
        admin.setName("opopop");
        System.out.println(adminDao.editAdminPassword(admin));
    }

    @Test
    void testAdminUsername(){
        Admin admin =new Admin();
        admin.setUsername("rvt");
        admin.setPassword("hnuinui");
        admin.setName("rvt");
        System.out.println(adminDao.editAdminUsername(admin));
    }

}
