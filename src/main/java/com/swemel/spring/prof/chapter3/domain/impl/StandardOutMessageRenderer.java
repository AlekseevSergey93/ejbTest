package com.swemel.spring.prof.chapter3.domain.impl;

import com.swemel.spring.prof.chapter2.MessageProvider;
import com.swemel.spring.prof.chapter2.MessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("renderer")
public class StandardOutMessageRenderer implements MessageRenderer {

    MessageProvider provider;

    public void render() {

    }

    @Autowired
    public void setMessageProvider(MessageProvider provider) {
        this.provider = provider;
    }

    public MessageProvider getMessageProvider() {
        return null;
    }
}
