package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther yangxiaolong
 * @create 2025/4/20
 */
@RestController
@RefreshScope
public class HelloController {

    // 从 Nacos 配置中心获取配置，默认值为 "Default Message"
    @Value("${message:Default Message}")
    private String message;

    @GetMapping("/hello")
    public String hello() {
        return message;
    }

}
