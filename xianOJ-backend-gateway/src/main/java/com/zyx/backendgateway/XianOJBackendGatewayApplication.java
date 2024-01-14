package com.zyx.backendgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/12 012 11:50
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class XianOJBackendGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(XianOJBackendGatewayApplication.class, args);
    }
}
