package cn.ouyangfan.mall.sibo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @auth 张庆生
 * @date 2020/11/4 12:10
 */
@SpringBootApplication(scanBasePackages = "cn.ouyangfan.mall.sibo")
public class AuthStarter {

    public static void main(String[] args) {
        SpringApplication.run(AuthStarter.class, args);
    }
}
