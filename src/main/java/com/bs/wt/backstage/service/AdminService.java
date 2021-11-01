/*@Time : 2021/6/25 18:34
 *@Author : 韦佗
 *@File : adminSerice.java
 *@Software : IntelliJ IDEA
 */
package com.bs.wt.backstage.service;

import com.bs.wt.backstage.bean.Admin;
import com.bs.wt.backstage.bean.Constant;
import com.bs.wt.backstage.bean.JsonCode;
import com.bs.wt.backstage.bean.QueryInfo;
import com.bs.wt.backstage.dao.mysql.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import com.bs.wt.backstage.bean.Re;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
@Validated//表示开启sprint的校检框架，会自动扫描方法里的@Valid（@Valid注解一般写在接口即可）
@Service
public class AdminService {


    @Autowired
    private AdminDao adminDao;
    /**
     * 判断是否是超级管理员
     * @return
     */
    public boolean isSuperAdmin(Admin admin){
        boolean judge=false;//默认不是
        if(admin!=null){
            if(admin.getRole()==1){
                judge=true;
            }
        }
        return judge;
    }

    /**
     * 根据账户名读取指定账户
     * @param username
     * @return
     */
    public Admin get(@NotNull String username) {
        Admin admin=null;
        if(username!=null){
            admin=adminDao.getAdmin(username);
        }
        return admin;
    }


    /**
     * 登录方法
     *
     * @param username 账户名，不能为空
     * @param password 密码，不能为空
     * @return true表示登陆成功，false表示登陆失败
     */
    public boolean login(String username, String password){
        boolean judge=false;
        if(adminDao.login(username, SHA.getResult(password))==1){
            judge=true;
        }
        return judge;
    }

    /**
     * 分页方法
     * @param queryInfo 查询对象
     * @return
     * */
    public Map<String, Object> query(QueryInfo queryInfo){
        // 获取最大列表数和当前编码
        int numbers = adminDao.getAdminCounts("%"+ queryInfo.getQuery() +"%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<Admin> listAdmin = adminDao.getAdminList("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("count", numbers);
        map.put("listAdmin", listAdmin);
        return map;
    }

    /**
     * 修改用户权限方法
     * @param username
     * @param role
     * */
    public boolean updateAdminRole(String username, Boolean role){
        boolean statues = false;
        if(adminDao.updateRole(username, role)){
            statues = true;
        }
        return statues;
    }

    /**
     * 删除用户方法
     * @param username
     * */
    public Boolean deleteAdmin(String username){
        boolean status = false;
        if(adminDao.deleteAdmin(username)){
            status = true;
        }
        return status;
    }

    /**
     * 用户修改
     * */
    public Map<String, Object> update(@Valid @NotNull Admin admin){
        Map<String, Object> map=new HashMap<String, Object>();
        Re re = new Re();
//        if (!re.rePassword(admin.getPassword())){
//            map.put(Constant.JSON_MESSAGE, "账户修改失败：密码包含为数字、大小写字母！");
//            return map;
//        }
        if(!re.reName(admin.getName())){
            map.put(Constant.JSON_MESSAGE, "账户修改失败：用户名包含为中文、数字、大小写字母！");
            return map;
        }

        if(admin!=null){
            if(admin.getName().length()<2){
                map.put(Constant.JSON_MESSAGE, "账户修改失败：用户名长度应在 2 到 20 个字符");
                return map;
            }else {
                Integer role=admin.getRole();
                if (role==null){
                    map.put(Constant.JSON_MESSAGE, "账户添加失败：请选择用户身份");
                    return map;
                }else {
                    if(adminDao.updateAdmin(admin)){
                        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
                        return map;
                    }else {
                        map.put(Constant.JSON_MESSAGE, "账户修改失败：用户信息填写异常！！！");
                        return map;
                    }
                }
            }
        }else {
            map.put(Constant.JSON_MESSAGE, "账户修改失败：用户信息填写异常！！！");
            return map;
        }
    }

    /**
     * 修改的用户信息获取方法
     * */
    public Admin getEditAdmin(String username){
        return  adminDao.getAdmin(username);
    }


    /**
     * 添加用户
     * 1.账户名、姓名、角色不能为空
     * 2.账户名不能重名
     * 3.密码默认是123456
     * */
    public Map<String, Object> add(@Valid @NotNull Admin admin){
        Map<String, Object> map=new HashMap<String, Object>();

        Re re = new Re();
        if(!re.reName(admin.getName())){
            map.put(Constant.JSON_MESSAGE, "账户添加失败：用户名中只能含有中文、数字或者字母！！！");
            return map;
        }
        if(!re.reUsername(admin.getUsername())){
            map.put(Constant.JSON_MESSAGE, "账户添加失败：登录名中只能含有数字或者字母！！");
            return map;
        }

        if(admin!=null){
            if(admin.getUsername().length()<2||admin.getUsername().length()>20){
                map.put(Constant.JSON_MESSAGE, "账户添加失败：账户名长度在 2 到 20 个字符");
                return map;
            }
            if(admin.getName().length()<2||admin.getName().length()>20){
                map.put(Constant.JSON_MESSAGE, "账户添加失败：姓名长度在 2 到 20 个字符");
                return map;
            }
            Integer role=admin.getRole();
            if(role==null){//角色信息不能为空
                map.put(Constant.JSON_MESSAGE, "账户添加失败：请选择用户身份");
                return map;
            }else{
                if(role>=3||role<=0){
                    map.put(Constant.JSON_MESSAGE, "账户添加失败：用户身份只能是普通用户或是管理员");
                    return map;
                }
            }
            // 查询是否重名
            if(adminDao.getAddAdmin(admin.getUsername())==0){
                admin.setPassword(SHA.getResult("123456"));//将密码加密
                admin.setCreateTime(Calendar.getInstance().getTime());//获取当前时间为创建时间
                adminDao.save(admin.getUsername(),
                        admin.getPassword(),
                        admin.getName(),
                        admin.getRole(),
                        admin.getCreateTime());
                map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
                return map;
            }else {
                map.put(Constant.JSON_MESSAGE,"账户添加失败：账户名重名");
                return map;
            }
        }else {
            map.put(Constant.JSON_CODE, JsonCode.ERROR.getValue());
            return map;
        }

//    /**
//     * 密码修改
//     * */
//     public Map<String, Object> editPassword(){
//
//        }

    }
}
