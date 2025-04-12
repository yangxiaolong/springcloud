package org.example;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * @auther yangxiaolong
 * @create 2025/4/7
 */
@Configuration
public class OkHttpConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .requestFactory(this::clientHttpRequestFactory)
                .interceptors(new RTLogInterceptor())
                .build();
    }

    @Bean
    public OkHttp3ClientHttpRequestFactory clientHttpRequestFactory() {
        return new OkHttp3ClientHttpRequestFactory();
    }

}
