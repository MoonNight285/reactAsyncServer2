package com.example.reactasyncserver2.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 모든 페이지에 적용시킬때 사용 또는 특정페이지만 설정가능
        // addMapping() : 지정한 패턴에 맞는 페이지에 대해서 접근 권한을 확인
        // allowedOrigins(url) : 접근 허용할 외부 url
        // registry.addMapping("/**").allowedOrigins("http://localhost:3000", "http://localhost:4000");
    }
}
