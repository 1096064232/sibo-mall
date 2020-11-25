package cn.ouyangfan.mall.sibo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"cn.ouyangfan.mall.sibo"})
public class AdminStarter {

    public static void main(String[] args) {
        SpringApplication.run(AdminStarter.class, args);
        System.out.println("启动完成");
    }


}
