package com.atguigu.boot05webadmin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootTest
@Slf4j
class Boot05WebAdminApplicationTests {

    @Autowired//容器中有这个组件，自动注入
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
//        jdbcTemplate.queryForObject("select * from db1",)
//        jdbcTemplate.queryForList("select * from db1",)
        Long aLong = jdbcTemplate.queryForObject("select count(*) from tb_brand", Long.class);
        System.out.println(aLong);
        log.info("数据源类型"+dataSource.getClass());

    }

}
