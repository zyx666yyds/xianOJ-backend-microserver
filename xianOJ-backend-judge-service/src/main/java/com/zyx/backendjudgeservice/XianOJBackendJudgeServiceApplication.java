package com.zyx.backendjudgeservice;

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
@MapperScan("com.zyx.backendjudgeservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.zyx")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.zyx.backendserviceclient.service"})
public class XianOJBackendJudgeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(XianOJBackendJudgeServiceApplication.class, args);
    }
}
