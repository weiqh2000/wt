package com.bs.wt.backstage.dao.phoenix;
import com.bs.wt.backstage.bean.phoenix.InfoTouTiao;
import com.bs.wt.backstage.bean.phoenix.AllPhoenixBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MyTestPhoenix {

    List<InfoTouTiao> getAll();

    List<AllPhoenixBean> gettest6();
}
