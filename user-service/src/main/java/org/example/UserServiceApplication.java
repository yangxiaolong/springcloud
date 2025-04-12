package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther yangxiaolong
 * @create 2025/4/12
 */
@SpringBootApplication
@RestController
public class UserServiceApplication {

    @GetMapping("/api/users/test")
    public String getUser(@RequestHeader("X-User-Header") String userHeader) {
        return "Received user request with header: " + userHeader;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}