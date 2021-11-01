package com.bs.wt.backstage.dao.phoenix;

import com.bs.wt.backstage.bean.phoenix.AllPhoenixBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.bs.wt.backstage.bean.phoenix.QueryWebInfo;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PhoenixWebTest {
    @Autowired
    PhoenixWebDao phoenixWebDao;


    @Test
    void testGetBusinessCounts(){
        System.out.println(phoenixWebDao.getBusinessCounts("%%"));
        System.out.println(phoenixWebDao.getRecreationCounts("%%"));
        System.out.println(phoenixWebDao.getScienceCounts("%%"));
        System.out.println(phoenixWebDao.getSportsCounts("%%"));
    }

    @Test
    void testGetTitleBusiness(){
        QueryWebInfo queryWebInfo = new QueryWebInfo();
        List<AllPhoenixBean> query = phoenixWebDao.getTitleBusiness("%"+queryWebInfo.getTitle()+"%", 10,0);
        for (AllPhoenixBean i:query){
            System.out.println(i);
        }
    }

    @Test
    void testGetTitleRecreation(){
        QueryWebInfo queryWebInfo = new QueryWebInfo();
        List<AllPhoenixBean> query = phoenixWebDao.getTitleRecreation("%"+queryWebInfo.getTitle()+"%", 10,0);
        for (AllPhoenixBean i:query){
            System.out.println(i);
        }
    }

    @Test
    void testGetTitleScience(){
        QueryWebInfo queryWebInfo = new QueryWebInfo();
        List<AllPhoenixBean> query = phoenixWebDao.getTitleScience("%"+queryWebInfo.getTitle()+"%", 5,5);
        for (AllPhoenixBean i:query){
            System.out.println(i);
        }
    }

    @Test
    void testGetTitleSports(){
        QueryWebInfo queryWebInfo = new QueryWebInfo();
        List<AllPhoenixBean> query = phoenixWebDao.getTitleSports("%"+queryWebInfo.getTitle()+"%", 5,5);
        for (AllPhoenixBean i:query){
            System.out.println(i);
        }
    }

    @Test
    void testGetBusinessArticle(){
        System.out.println(phoenixWebDao.getBusinessArticle("6982770090101965349"));
    }
    @Test
    void testGetRecreationArticle(){
        System.out.println(phoenixWebDao.getRecreationArticle("6982761308252881438"));
    }
    @Test
    void testGetScienceArticle(){
        System.out.println(phoenixWebDao.getScienceArticle("6982790005609628197"));
    }
    @Test
    void testGetSportsArticle(){
        System.out.println(phoenixWebDao.getSportsArticle("6982770033571168801"));
    }
}