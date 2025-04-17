package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther yangxiaolong
 * @create 2025/4/16
 */
@SpringBootApplication
public class ConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}


@RestController
@RefreshScope
class ConfigClientController {

    @Value("${app.name}")
    private String appName;

    @Value("${app.message}")
    private String appMessage;

    @GetMapping("/info")
    public String info() {
        return "Name: " + appName + ", Message: " + appMessage;
    }

}