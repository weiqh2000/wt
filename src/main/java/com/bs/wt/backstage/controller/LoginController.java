/*@Time : 2021/6/16 0:34
 *@Author : 韦佗
 *@File : LoginController.java
 *@Software : IntelliJ IDEA
 */
package com.bs.wt.backstage.controller;


import com.bs.wt.backstage.bean.Admin;
import com.bs.wt.backstage.bean.Constant;
import com.bs.wt.backstage.bean.JsonCode;
import com.bs.wt.backstage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/backstage")
public class LoginController {

    @Autowired
    private AdminService adminService;

    /**
     * 实现登录
     * @param username
     * @param password
     * @param session
     * @return 0 --> 登录成功      -1 --> 登录失败
     * */
    @RequestMapping("/login")
    public Map<String, Object> login(String username, String password, HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.ERROR.getValue());
        if(adminService.login(username, password)){//如果登录成功
            Admin admin=adminService.get(username);
            session.setAttribute("admin",admin);
            map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
            map.put(Constant.JSON_DATA,admin);//将账户名值传递到前端先存储，供后端交互
        }else{
            map.put(Constant.JSON_MESSAGE, "登录失败：用户名和密码错误");
        }
        return map;
    }

    /**
     * 获取当前登陆账户信息
     * @param session
     * @return
     */
    @GetMapping("/admin")
    public Map<String, Object> getAdminOfLogin(HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_DATA,session.getAttribute("admin"));//将账户名值传递到前端先存储，供后端交互
        return map;
    }
    /**
     * 注销登录，清除后端的session
     * */
    @GetMapping("/logout")
    public Map<String, Object> logout(HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        session.removeAttribute("admin");
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_MESSAGE, "成功注销用户");
        return map;
    }
}
