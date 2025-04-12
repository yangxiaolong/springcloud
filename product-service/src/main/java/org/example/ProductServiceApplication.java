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
public class ProductServiceApplication {

    @GetMapping("/api/products/test")
    public String getProduct(@RequestHeader("X-Product-Header") String productHeader) {
        return "Received product request with header: " + productHeader;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}