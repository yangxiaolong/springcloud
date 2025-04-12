package org.server3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @auther yangxiaolong
 * @create 2025/3/27
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer3Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer3Application.class, args);
    }
}