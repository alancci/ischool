package com.project.ischool;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
@MapperScan("com.project.ischool.mapper")
public class IschoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(IschoolApplication.class, args);
    }

}
