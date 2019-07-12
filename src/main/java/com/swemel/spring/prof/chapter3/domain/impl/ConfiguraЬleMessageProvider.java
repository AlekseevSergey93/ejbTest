package com.swemel.spring.prof.chapter3.domain.impl;

import com.swemel.spring.prof.chapter2.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("provider3")
public class ConfiguraЬleMessageProvider implements MessageProvider {

    private String message;

    @Autowired
    public ConfiguraЬleMessageProvider(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
