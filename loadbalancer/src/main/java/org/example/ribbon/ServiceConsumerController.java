package org.example.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auther yangxiaolong
 * @create 2025/3/31
 */
@RestController
public class ServiceConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String consumeService() {
        String url = "http://eureka-client/greeting";
        return restTemplate.getForObject(url, String.class);
    }

}