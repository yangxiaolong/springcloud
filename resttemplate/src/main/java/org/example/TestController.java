package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auther yangxiaolong
 * @create 2025/4/7
 */
@RestController
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/test")
    public String test() {
        return restTemplate.getForObject("https://www.baidu.com/", String.class);
    }

}
