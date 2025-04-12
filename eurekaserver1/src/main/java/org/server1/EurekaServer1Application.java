package org.server1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @auther yangxiaolong
 * @create 2025/3/27
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer1Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer1Application.class, args);
    }

}