package org.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("eureka-client")
public interface GreetingClient {

    @RequestMapping("/greeting")
    String greeting();

    @PostMapping(value = "/greeting")
    String postGreeting(@RequestBody Person person);

}