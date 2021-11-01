package com.bs.wt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@MapperScan({"com.bs.wt.backstage.dao.mysql","com.bs.wt.backstage.dao.phoenix"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class WtApplication {

    public static void main(String[] args) {
        SpringApplication.run(WtApplication.class, args);
    }

}
