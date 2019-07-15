package com.swemel.spring.prof.chapter3.services;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

public class BeanNamingTest {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("strings-context.xml");
        ctx.refresh();
        Map<String, String> map = ctx.getBeansOfType(String.class);
        map.entrySet().stream().forEach(e -> System.out.println(e.getKey()));
    }
}
