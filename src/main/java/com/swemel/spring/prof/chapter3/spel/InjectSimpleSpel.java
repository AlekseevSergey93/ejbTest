package com.swemel.spring.prof.chapter3.spel;

import java.util.Objects;

public class InjectSimpleSpel {

    private String name;
    private int age;
    private float height;
    private boolean programmer;
    private Long ageInSeconds;

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

    public Long getAgeInSeconds() {
        return ageInSeconds;
    }

    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    @Override
    public String toString() {
        return  "name=" + name + "\n" +
                "age=" + age + "\n" +
                "height=" + height + "\n" +
                "programmer=" + programmer + "\n" +
                "ageInSeconds=" + ageInSeconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InjectSimpleSpel that = (InjectSimpleSpel) o;
        return age == that.age &&
                Float.compare(that.height, height) == 0 &&
                programmer == that.programmer &&
                name.equals(that.name) &&
                ageInSeconds.equals(that.ageInSeconds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, height, programmer, ageInSeconds);
    }
}
