/*@Time : 2021/7/9 2:29
 *@Author : 韦佗
 *@File : WebService.java
 *@Software : IntelliJ IDEA
 */
package com.bs.wt.backstage.service;


import com.bs.wt.backstage.bean.phoenix.QueryWebInfo;
import com.bs.wt.backstage.dao.phoenix.PhoenixWebDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import com.bs.wt.backstage.bean.phoenix.AllPhoenixBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
@Validated//表示开启sprint的校检框架，会自动扫描方法里的@Valid（@Valid注解一般写在接口即可）
@Service
public class WebService {

    @Autowired
    PhoenixWebDao phoenixWebDao;


    /**
     * 科学模块的分页方法
     * @param queryWebInfo 查询对象
     * @return
     * */
    public Map<String, Object> queryScience(QueryWebInfo queryWebInfo){
        Map<String, Object> map=new HashMap<String, Object>();
        int numbers = phoenixWebDao.getScienceCounts("%"+queryWebInfo.getTitle()+"%");
        int pageStart = queryWebInfo.getPageNum();
        List<AllPhoenixBean> listScienceCount = phoenixWebDao.getTitleScience("%"+queryWebInfo.getTitle()+"%",10,pageStart);
        map.put("count", numbers);
        map.put("listScienceCount", listScienceCount);
        return map;
    }

    /**
     * 科学通过gid获取详细
     * @param gid
     * @return AllPhoenixBean
     * */
    public AllPhoenixBean queryScienceGid(String gid){
        AllPhoenixBean Science = phoenixWebDao.getScienceArticle(gid);
        return Science;
    }


    /**
     * 经济模块的分页方法
     * @param queryWebInfo 查询对象
     * @return
     * */
    public Map<String, Object> queryBusiness(QueryWebInfo queryWebInfo){
        Map<String, Object> map=new HashMap<String, Object>();
        int numbers = phoenixWebDao.getBusinessCounts("%"+queryWebInfo.getTitle()+"%");
        int pageStart = queryWebInfo.getPageNum();
        List<AllPhoenixBean> listBusinessCount = phoenixWebDao.getTitleBusiness("%"+queryWebInfo.getTitle()+"%",10,pageStart);
        map.put("count", numbers);
        map.put("listBusinessCount", listBusinessCount);
        return map;
    }

    /**
     * 经济通过gid获取详细
     * @param gid
     * @return AllPhoenixBean
     * */
    public AllPhoenixBean queryBusinessGid(String gid){
        AllPhoenixBean Business = phoenixWebDao.getBusinessArticle(gid);
        return Business;
    }




    /**
     * 经济模块的分页方法
     * @param queryWebInfo 查询对象
     * @return
     * */
    public Map<String, Object> queryRecreation(QueryWebInfo queryWebInfo){
        Map<String, Object> map=new HashMap<String, Object>();
        int numbers = phoenixWebDao.getRecreationCounts("%"+queryWebInfo.getTitle()+"%");
        int pageStart = queryWebInfo.getPageNum();
        List<AllPhoenixBean> listRecreationCount = phoenixWebDao.getTitleRecreation("%"+queryWebInfo.getTitle()+"%",10,pageStart);
        map.put("count", numbers);
        map.put("listRecreationCount", listRecreationCount);
        return map;
    }

    /**
     * 经济通过gid获取详细
     * @param gid
     * @return AllPhoenixBean
     * */
    public AllPhoenixBean queryRecreationGid(String gid){
        AllPhoenixBean Recreation = phoenixWebDao.getRecreationArticle(gid);
        return Recreation;
    }


    public Map<String, Object> queryCounts(){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("SportsCounts",phoenixWebDao.getSportsCounts("%%"));
        map.put("ScienceCounts",phoenixWebDao.getScienceCounts("%%"));
        map.put("RecreationCounts",phoenixWebDao.getRecreationCounts("%%"));
        map.put("BusinessCounts",phoenixWebDao.getBusinessCounts("%%"));
        return map;
    }




    /**
     * 经济模块的分页方法
     * @param queryWebInfo 查询对象
     * @return
     * */
    public Map<String, Object> querySports(QueryWebInfo queryWebInfo){
        Map<String, Object> map=new HashMap<String, Object>();
        int numbers = phoenixWebDao.getSportsCounts("%"+queryWebInfo.getTitle()+"%");
        int pageStart = queryWebInfo.getPageNum();
        List<AllPhoenixBean> listSportsCount = phoenixWebDao.getTitleSports("%"+queryWebInfo.getTitle()+"%",10,pageStart);
        map.put("count", numbers);
        map.put("listSportsCount", listSportsCount);
        return map;
    }

    /**
     * 经济通过gid获取详细
     * @param gid
     * @return AllPhoenixBean
     * */
    public AllPhoenixBean querySportsGid(String gid){
        AllPhoenixBean Sports = phoenixWebDao.getSportsArticle(gid);
        return Sports;
    }



}
