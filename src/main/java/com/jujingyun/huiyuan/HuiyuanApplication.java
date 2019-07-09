package com.jujingyun.huiyuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jujingyun.huiyuan.dao")
public class HuiyuanApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuiyuanApplication.class, args);
    }

}
