package com.atguigu.boot05webadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "com.atguigu.boot05webadmin")
@SpringBootApplication
public class Boot05WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot05WebAdminApplication.class, args);
        System.out.println("1");
        System.out.println("2");
        System.out.println("hot-fix");
        System.out.println("hot-fix冲突1");
    }

}
