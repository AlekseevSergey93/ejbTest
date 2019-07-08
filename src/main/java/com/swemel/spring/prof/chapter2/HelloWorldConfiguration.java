package com.swemel.spring.prof.chapter2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public MessageProvider provider() {
        return new MessageProviderImpl();
    }

    @Bean
    public MessageRenderer renderer() {
        MessageRenderer mr = new MessageRendererImpl();
        mr.setMessageProvider(provider());
        return mr;
    }
}
