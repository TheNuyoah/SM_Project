package com.Angelo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.Angelo.mapper")
@EnableScheduling //定时任务注解
public class SmContentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmContentApiApplication.class, args);
    }

}
