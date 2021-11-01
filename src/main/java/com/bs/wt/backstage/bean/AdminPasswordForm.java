/*@Time : 2021/7/5 1:17
 *@Author : 韦佗
 *@File : AdminPasswordForm.java
 *@Software : IntelliJ IDEA
 */
package com.bs.wt.backstage.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminPasswordForm {

    private  String password;//原密码

    private  String newPass;//新密码

    private  String rePass;//确认密码
}
