package com.swemel.spring.prof.chapter3.domain.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("singer")
public class Singer {

    @Autowired
    private Inspiratioп inspiratioп;

    public void sing() {
        System.out.println("... " + inspiratioп.getLyric());
    }
}
