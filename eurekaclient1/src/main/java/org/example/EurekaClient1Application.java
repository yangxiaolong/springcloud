package org.example;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther yangxiaolong
 * @create 2025/3/27
 */
@SpringBootApplication
@RestController
public class EurekaClient1Application implements GreetingController {

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private int port;

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient1Application.class, args);
    }

    @Override
    public String greeting() {
        return String.format(
                "Hello from '%s'!", eurekaClient.getApplication(appName).getName() + port);
    }

    @Override
    public String postGreeting(Person person) {
        return person.getId() + person.getName() + port;
    }

}