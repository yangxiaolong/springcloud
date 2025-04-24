package my.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auther yangxiaolong
 * @create 2025/4/24
 */
@SpringBootApplication
@RestController
public class ZkProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZkProviderApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }

    @Value("${server.port}")
    public String port;


    @GetMapping("/hello")
    public String hello() {
        return "Hello from ZooKeeper-Registered Service! Port: " + port;
    }

}

@RestController
class ServiceConsumerController {

    private final RestTemplate restTemplate;

    public ServiceConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/invoke-provider")
    public String invokeProvider() {
        // 直接使用服务提供者的应用名称（my-service-provider）进行调用，负载均衡自动选择实例
        String response = restTemplate.getForObject("http://zk-provider/hello", String.class);
        return "Consumer received: " + response;
    }

}
