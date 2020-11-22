package cn.ouyangfan.mall.sibo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"cn.ouyangfan.mall.sibo"})
public class SecurityStarter {

    public static void main(String[] args) {
        SpringApplication.run(SecurityStarter.class, args);
    }
}
