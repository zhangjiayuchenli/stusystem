package com.njit.stusystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.njit.stusystem.mapper")
public class StusystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StusystemApplication.class, args);
    }

}
