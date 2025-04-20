package org.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @auther yangxiaolong
 * @create 2025/4/20
 */
// Feign 客户端接口，指定服务名为 "service-provider"
@FeignClient(name = "service-provider")
public interface ProviderFeignClient {

    @GetMapping("/hello")
    String hello();

}
