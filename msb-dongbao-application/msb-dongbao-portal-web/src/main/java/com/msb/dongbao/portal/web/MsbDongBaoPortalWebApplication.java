package com.msb.dongbao.portal.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.msb")
@MapperScan(basePackages = "com.msb.dongbao.ums.mapper")
public class MsbDongBaoPortalWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsbDongBaoPortalWebApplication.class,args);
    }
}
