package com.bs.wt.backstage.dao.mysql;

import com.bs.wt.backstage.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /**
     * 处理数据库的登录方法
     * @param username 账户名
     * @param password 密码
     * @return 返回匹配的账户总数
     */
    @Select("SELECT count(1) FROM admin where username=#{username} and password=#{password}")
    int login(String username, String password);
    public User getUserByMassage(@Param("username") String username, @Param("password") String password);
}
