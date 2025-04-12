package org.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther yangxiaolong
 * @create 2025/3/27
 */
public interface GreetingController {

    @RequestMapping("/greeting")
    String greeting();

    @PostMapping(value = "/greeting")
    String postGreeting(@RequestBody Person person);

}