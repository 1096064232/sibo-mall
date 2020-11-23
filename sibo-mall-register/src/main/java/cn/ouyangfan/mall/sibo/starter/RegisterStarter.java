package cn.ouyangfan.mall.sibo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication(scanBasePackages = {"cn.ouyangfan.mall.sibo"})
public class RegisterStarter {

    public static void main(String[] args) {
        SpringApplication.run(RegisterStarter.class,args);
    }
}
