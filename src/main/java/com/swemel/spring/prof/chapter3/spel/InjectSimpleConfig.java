package com.swemel.spring.prof.chapter3.spel;

import org.springframework.stereotype.Component;

@Component( "injectSimpleConfig")
public class InjectSimpleConfig {

    private String name = "John Mayer";
    private int age = 39;
    private float height = 1.92f;
    private boolean programmer = false;
    private Long ageinSeconds = 12414011121L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public Long getAgeinSeconds() {
        return ageinSeconds;
    }

    public void setAgeinSeconds(Long ageinSeconds) {
        this.ageinSeconds = ageinSeconds;
    }
}
