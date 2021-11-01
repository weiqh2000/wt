/*@Time : 2021/7/3 15:03
 *@Author : 韦佗
 *@File : Re.java
 *@Software : IntelliJ IDEA
 */
package com.bs.wt.backstage.bean;
import java.util.regex.*;
public class Re {

    // 用于用户名 -----> 匹配中文、数字、字母大小写
    // ^[a-z0-9A-Z\u4e00-\u9fa5\u4e00-\u9FA5]+$
    // Pattern.matches("^[a-z0-9A-Z]+$","2223"))
    // 用于密码 -----> 匹配数字字母大小写
    // ^[a-z0-9A-Z]+$

    public Boolean reUsername(String username){
        Boolean status = false;
        if(Pattern.matches("^[a-z0-9A-Z]+$",username)){
            status = true;
        }
        return status;
    }

    public Boolean rePassword(String password){
        Boolean status = false;
        if(Pattern.matches("^[a-z0-9A-Z]+$",password)){
            status = true;
        }
        return status;
    }

    public Boolean reName(String name){
        Boolean status = false;
        if(Pattern.matches("^[a-z0-9A-Z\\u4e00-\\u9fa5\\u4e00-\\u9FA5]+$",name)){
            status = true;
        }
        return status;
    }

}
