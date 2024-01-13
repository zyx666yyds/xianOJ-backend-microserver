package com.zyx.backenduserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/12 012 11:50
 */
// todo 如需开启 Redis，须移除 exclude 中的内容
@SpringBootApplication
@MapperScan("com.zyx.backenduserservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.zyx")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.zyx.backendserviceclient.service"})
public class XianOJBackendUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(XianOJBackendUserServiceApplication.class, args);
    }
}
