package org.example;

import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;

@SpringBootApplication
@EnableFeignClients
@RestController
public class FeignClientApplication {

    @Autowired
    private GreetingClient greetingClient;

    public static void main(String[] args) {
        SpringApplication.run(FeignClientApplication.class, args);
    }

    @GetMapping("/get-greeting")
    public String greeting() {
        return greetingClient.greeting();
    }

    @PostMapping("/post-greeting")
    public String postGreeting() {
        Person person = new Person();
        person.setId(1L);
        person.setName("name1");
        return greetingClient.postGreeting(person);
    }


    @Autowired(required = false)
    HttpClientConnectionManager httpClientConnectionManager;

    @GetMapping("/monitor")
    public String monitor() {
        String monitor = ((PoolingHttpClientConnectionManager) httpClientConnectionManager).getTotalStats().toString();
        System.out.println(monitor);
        return monitor;
    }


    @Autowired(required = false)
    okhttp3.OkHttpClient okHttpClient;

    @GetMapping("/okhttp-monitor")
    public String okhttpMonitor() throws NoSuchFieldException, IllegalAccessException {
        Field dispatcherfField = OkHttpClient.class.getDeclaredField("dispatcher");
        dispatcherfField.setAccessible(true);
        Dispatcher dispatcher = (Dispatcher) dispatcherfField.get(okHttpClient);
        System.out.println("dispatcher.runningCallsCount: " + dispatcher.runningCallsCount());
        System.out.println("dispatcher.queuedCallsCount: " + dispatcher.queuedCallsCount());
        System.out.println("dispatcher.maxRequestsPerHost: " + dispatcher.getMaxRequestsPerHost());
        System.out.println("dispatcher.maxRequests: " + dispatcher.getMaxRequests());

        ExecutorService executorService = dispatcher.executorService();
        System.out.println("executorService: " + executorService);

        ConnectionPool connectionPool = okHttpClient.connectionPool();
        System.out.println("connectionCount: " + connectionPool.connectionCount());
        System.out.println("idleConnectionCount: " + connectionPool.idleConnectionCount());

        return "";
    }

}
