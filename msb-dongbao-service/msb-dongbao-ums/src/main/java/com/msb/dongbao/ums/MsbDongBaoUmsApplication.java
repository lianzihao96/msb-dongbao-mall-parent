package com.msb.dongbao.ums;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.msb.dongbao.ums.mapper")
public class MsbDongBaoUmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsbDongBaoUmsApplication.class,args);
    }
}
