package com.bs.wt.backstage.dao.mysql;

import com.bs.wt.backstage.bean.Admin;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminDao {

    //查询用户是否存在
    Integer login(@Param("username") String username, @Param("password") String password);

    //通过用户名查找用户信息
    Admin getAdmin(@Param("username") String username);

    //查找全部用户
    List<Admin> getAdminList(@Param("username") String name, @Param("pageStart") int PageStart, @Param("pageSize") int pageSize);

    //计算用户个数
    Integer getAdminCounts(@Param("username") String name);

    //修改用户权限true
    Boolean updateRole(@Param("username") String username, @Param("role") Boolean role);

    //查询用户是否存在
    int getAddAdmin(@Param("username") String username);

    //添加用户
    int save(@Param("username") String username,
             @Param("password") String password,
             @Param("name") String name,
             @Param("role") Integer role,
             @Param("createTime") Date createTime);

    // 删除用户
    Boolean deleteAdmin(@Param("username") String username);

    // 用户编辑
    Boolean updateAdmin(Admin admin);

    // 用户的密码修改
    Boolean editAdminPassword(Admin admin);

    // 用户的用户名修改
    Boolean editAdminUsername(Admin admin);
}
