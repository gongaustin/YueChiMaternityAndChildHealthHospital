package com.austin.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description:启动器Starter，发现bean注册并进IOC容器
 * @Author: GongJun
 * @Date: Created in 11:16 2021/1/25
 * */
//@SpringBootApplication已经包括@ComponentScan和@EnableAutoConfiguration,单独写出来声明Package后则@SpringBootApplication中的就会失效
@SpringBootApplication
@EnableSwagger2
public class CommonApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(CommonApplicationStarter.class);
    }
}
