package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther yangxiaolong
 * @create 2025/4/20
 */
@RestController
public class ConsumerController {

    @Autowired
    ProviderFeignClient providerFeignClient;

    // 调用服务提供者的 Feign 客户端
    @GetMapping("/call-provider")
    public String callProvider() {
        return providerFeignClient.hello();
    }


}