package org.example;

import feign.Client;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.loadbalancer.FeignBlockingLoadBalancerClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @auther yangxiaolong
 * @create 2025/4/5
 */
@Component
@EnableScheduling
public class FeignMonitor {

    @Autowired
    private FeignBlockingLoadBalancerClient client;

    @Autowired(required = false)
    HttpClientConnectionManager httpClientConnectionManager;

    @Scheduled(fixedRate = 5000)
    public void monitor() {
        Client delegate = client.getDelegate();
        String delegateClassString = delegate.toString();
        if (delegateClassString.contains("Default")) {
            System.out.println("当前未启用连接池");
        } else if (delegateClassString.contains("feign.okhttp.OkHttpclient")) {
//            System.out.println(FeignMonitor4OkhttpUtil.monitor4http(delegate));
        } else if (delegateClassString.contains("feign.httpclient.ApacheHttpclient")) {
            System.out.println(httpClientConnectionManager.toString());
//            System.out.println(FeignMonitor4Httpclient.monitor4http(delegate));
        }

    }

}