package com.swemel.spring.prof.chapter3.domain.impl;

import com.swemel.spring.prof.chapter3.domain.ContentHolder;

public class LyricHolder implements ContentHolder {

    private String value = "You be the DJ, I'll be the driver";

    @Override
    public String toString() {
        return "LyricHolder{" +
                "value='" + value + '\'' +
                '}';
    }
}
