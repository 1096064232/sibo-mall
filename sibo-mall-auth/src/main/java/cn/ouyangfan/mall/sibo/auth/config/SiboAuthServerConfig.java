package cn.ouyangfan.mall.sibo.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 认真服务器配置
 *
 * @auth 张庆生
 * @date 2020/11/4 12:13
 */
@Configuration
@EnableAuthorizationServer
public class SiboAuthServerConfig extends AuthorizationServerConfigurerAdapter {
}
