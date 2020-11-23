package cn.ouyangfan.mall.sibo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"cn.ouyangfan.mall.sibo"})
public class GatewayStarter {

    public static void main(String[] args) {
        SpringApplication.run(GatewayStarter.class, args);
    }

    @GetMapping("/me")
    public Object user() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
