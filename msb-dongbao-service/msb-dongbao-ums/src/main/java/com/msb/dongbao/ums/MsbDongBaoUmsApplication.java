package com.msb.dongbao.ums;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.msb.dongbao.ums.mapper")
public class MsbDongBaoUmsApplication {

//    public class Application {
//        @PostConstruct
//        void started() {
//            TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
//        }
//    }

    public static void main(String[] args) {
        SpringApplication.run(MsbDongBaoUmsApplication.class,args);
    }
}
