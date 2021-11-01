/*@Time : 2021/7/9 15:52
 *@Author : 韦佗
 *@File : WebController.java
 *@Software : IntelliJ IDEA
 */
package com.bs.wt.backstage.web.nesweb;

import com.bs.wt.backstage.bean.Constant;
import com.bs.wt.backstage.bean.JsonCode;
import com.bs.wt.backstage.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bs.wt.backstage.bean.phoenix.QueryWebInfo;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/web")
public class WebController {
    @Autowired
    WebService webService;

    @RequestMapping("/query/business")
    public Map<String, Object> queryWebBusiness(QueryWebInfo queryWebInfo){
        System.out.println(queryWebInfo);
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_DATA,webService.queryBusiness(queryWebInfo));
        return map;
    }

    @RequestMapping("/query/business/gid")
    public Map<String, Object> queryBusinessGidInfo(String gid){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA,webService.queryBusinessGid(gid));
        return map;
    }


    @RequestMapping("/query/science")
    public Map<String, Object> queryWebScience(QueryWebInfo queryWebInfo){
        System.out.println(queryWebInfo);
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_DATA,webService.queryScience(queryWebInfo));
        return map;
    }

    @RequestMapping("/query/science/gid")
    public Map<String, Object> queryScienceGidInfo(String gid){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA,webService.queryScienceGid(gid));
        return map;
    }



    @RequestMapping("/query/recreation")
    public Map<String, Object> queryWebRecreation(QueryWebInfo queryWebInfo){
        System.out.println(queryWebInfo);
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_DATA,webService.queryRecreation(queryWebInfo));
        return map;
    }

    @RequestMapping("/query/recreation/gid")
    public Map<String, Object> queryRecreationGidInfo(String gid){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA,webService.queryRecreationGid(gid));
        return map;
    }


    @RequestMapping("/query/sports")
    public Map<String, Object> queryWebSports(QueryWebInfo queryWebInfo){
        System.out.println(queryWebInfo);
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_DATA,webService.querySports(queryWebInfo));
        return map;
    }

    @RequestMapping("/query/sports/gid")
    public Map<String, Object> querySportsGidInfo(String gid){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA,webService.querySportsGid(gid));
        return map;
    }

    @RequestMapping("/query/counts")
    public Map<String, Object> queryCount(){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA,webService.queryCounts());
        return map;
    }
}
