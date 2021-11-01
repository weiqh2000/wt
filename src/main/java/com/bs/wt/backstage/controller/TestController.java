/*@Time : 2021/6/9 9:40
 *@Author : 韦佗
 *@File : LoginController.java
 *@Software : IntelliJ IDEA
 */
package com.bs.wt.backstage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/backstage")
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "Test";
    }
}
