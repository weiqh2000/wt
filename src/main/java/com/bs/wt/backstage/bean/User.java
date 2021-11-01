/*@Time : 2021/6/16 0:18
 *@Author : 韦佗
 *@File : User.java
 *@Software : IntelliJ IDEA
 */
package com.bs.wt.backstage.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private String role;
    private boolean state;
}
