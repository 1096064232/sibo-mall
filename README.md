一、项目功能描述

二、项目结构描述

三、技术选型
    
    注册中心： eureka
    服务调用： openFeign
    服务降级： Hystrix
    服务网关： zuul
    服务配置： config
    服务总线： Bus 
    权限管理： oauth2、security


生成key：
 keytool -genkeypair -alias sibo -keyalg RSA -keypass 123456  -storepass 123456 -keystore D:\WorkSpace\sibo-mall\sibo-mall\key\sibo.key 
 
 127.0.0.1  admin.ouyangfan.cn
 127.0.0.1  sso.ouyangfan.cn
 127.0.0.1  sibo.ouyangfan.cn
 