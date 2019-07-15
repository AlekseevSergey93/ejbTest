package com.swemel.spring.prof.chapter3.services;

import com.swemel.spring.prof.chapter3.domain.impl.Singer;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Collectionlnjection {

    private Map<String, Object> map;
    private Properties props;
    private Set set;
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context.xml");
        ctx.refresh();
        Collectionlnjection instance = ctx.getBean("injectCollection", Collectionlnjection.class);
        instance.displayInfo();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("My start");
        for (int i = 0; i < 100000; i++) {
            Singer singer = ctx.getBean("singer", Singer.class);
        }
        stopWatch.stop();
        System.out.println("100k gets took " + stopWatch.getTotalTimeMillis() + "ms");

        ctx.close();
    }

    public void displayInfo() {
        System.out.println("Map contents: \n");
        map.entrySet().stream().forEach(e -> System.out.println("Key: " + e.getKey() + " - Value: " + e.getValue()));

        System.out.println("\nProperties contents:\n");
        props.entrySet().stream().forEach(e -> System.out.println("Key: " + e.getKey() + " - Value: " + e.getValue()));

        System.out.println("\nSet contents:\n");
        set.forEach(e -> System.out.println("Value: " + e));

        System.out.println("\nList contents:\n");
        list.forEach(e -> System.out.println("Value: " + e));
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }
}
