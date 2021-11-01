package com.bs.wt.backstage.dao.phoenix;

import com.bs.wt.backstage.bean.phoenix.AllPhoenixBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PhoenixWebDao {

    // 获取商业的标题
    List<AllPhoenixBean> getTitleBusiness(@Param("title") String title, @Param("pageStart") int PageStart, @Param("pageSize") int pageSize);

    // 获取娱乐的标题
    List<AllPhoenixBean> getTitleRecreation(@Param("title") String title, @Param("pageStart") int PageStart, @Param("pageSize") int pageSize);

    // 获取科学的标题
    List<AllPhoenixBean> getTitleScience(@Param("title") String title, @Param("pageStart") int PageStart, @Param("pageSize") int pageSize);

    // 获取运动的标题
    List<AllPhoenixBean> getTitleSports(@Param("title") String title, @Param("pageStart") int PageStart, @Param("pageSize") int pageSize);

    // 计算商业文章的章数
    Integer getBusinessCounts(@Param("title") String title);

   // 计算娱乐文章的章数
    Integer getRecreationCounts(@Param("title") String title);

    // 计算科学文章的章数
    Integer getScienceCounts(@Param("title") String title);

    // 计算运动文章的章数
    Integer getSportsCounts(@Param("title") String title);

    // gid 查询商业文章
    AllPhoenixBean getBusinessArticle(@Param("gid") String gid);
    // gid 查询娱乐文章
    AllPhoenixBean getRecreationArticle(@Param("gid") String gid);
    // gid 查询科学文章
    AllPhoenixBean getScienceArticle(@Param("gid") String gid);
    // gid 查询运动文章
    AllPhoenixBean getSportsArticle(@Param("gid") String gid);
}
