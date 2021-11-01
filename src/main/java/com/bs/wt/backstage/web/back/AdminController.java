/*@Time : 2021/7/1 1:20
 *@Author : 韦佗
 *@File : AdminController.java
 *@Software : IntelliJ IDEA
 */
package com.bs.wt.backstage.web.back;

import com.bs.wt.backstage.bean.Admin;
import com.bs.wt.backstage.bean.Constant;
import com.bs.wt.backstage.bean.JsonCode;
import com.bs.wt.backstage.bean.QueryInfo;
import com.bs.wt.backstage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/backstage/admin/manage")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 查询方法
     * 实现了模糊查询
     * 分页
     * 全部查询
     * */
    @RequestMapping("/query")
    public Map<String, Object> adminManage(QueryInfo queryInfo){
        System.out.println(queryInfo);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Constant.JSON_DATA,adminService.query(queryInfo));
        System.out.println(map);
        return map;
    }

    /**
     * 修改用户权限
     * 预先判断是否为当前用户
     * */
    @RequestMapping("/alterRole")
    public Map<String, Object> updateRole(String username, Boolean role, HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        Admin admin=((Admin) session.getAttribute("admin"));
        if(username.equals(admin.getUsername())){
            map.put(Constant.JSON_MESSAGE, "修改失败，不能修改自己的用户权限！！");
            return map;
        }else {
            if(adminService.updateAdminRole(username,role)){
                map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
            }else {
                map.put(Constant.JSON_MESSAGE, "修改失败，修改用户权限时出现了异常！");
            }
        }
        return map;
    }

    /**
     *  添加方法
     *
     * */
    @PostMapping
    public Map<String, Object> addAdmin(@RequestBody Admin admin){
        System.out.println(admin);
        return adminService.add(admin);
    }

    /**
     * 删除方法
     * 先验证是不是删除自己
     * */
    @DeleteMapping
    public Map<String, Object> deleAdmin(String username, HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        Admin admin=((Admin) session.getAttribute("admin"));
        if(username.equals(admin.getUsername())){
            map.put(Constant.JSON_MESSAGE, "删除失败，不能删除本身账户");
            return map;
        }else {
            if(adminService.deleteAdmin(username)){
                map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
            }else {
                map.put(Constant.JSON_MESSAGE, "删除失败，删除用户时出现了异常！");
            }
        }
        return map;
    }

    /**
     * 初始化编辑窗口的数据
     * @param username
     * return Admin
     * */
    @GetMapping("/getAdmin")
    public Admin getAdmin(String username){
        System.out.println(adminService.getEditAdmin(username));
        return adminService.getEditAdmin(username);
    }

    /**
     * 用户的修改
     * */
    @PostMapping("/editAdmin")
    public Map<String, Object> updateAdmin(@RequestBody Admin user, HttpSession session){
        Admin admin=((Admin) session.getAttribute("admin"));
        Map<String, Object> map = new HashMap<String, Object>();
        if(admin.getUsername().equals(user.getUsername())) {
            if(admin.getRole() == user.getRole()){
                map.put(Constant.JSON_MESSAGE, "不能修改自己的权限！！！");
                return map;
            }
        }
        return adminService.update(user);

    }
}
