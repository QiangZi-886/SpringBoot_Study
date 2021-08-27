package com.yang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yang.mybatis.repository")//还需要再配置扫描包，需要扫描mybatis对应的mapper接口
public class MybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class,args);
    }
}
