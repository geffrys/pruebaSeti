package com.geffrys.seti.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.geffrys.seti.config.Interceptor.JsonXmlInterceptor;

public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private JsonXmlInterceptor jsonXmlInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jsonXmlInterceptor);
    }


}
