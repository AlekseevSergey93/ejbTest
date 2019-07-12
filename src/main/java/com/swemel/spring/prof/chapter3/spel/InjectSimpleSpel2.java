package com.swemel.spring.prof.chapter3.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("injectSimpleSpel2")
public class InjectSimpleSpel2 {

    @Value("#{injectSimpleConfig.name}")
    private String name;

    @Value("#{injectSimpleConfig.age + 2}")
    private int age;

    @Value("#{injectSimpleConfig.height}")
    private float height;

    @Value("#{injectSimpleConfig.programmer}")
    private boolean programmer;

    @Value("#{injectSimpleConfig.ageinSeconds}")
    private Long ageInSeconds;

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
        InjectSimpleSpel2 that = (InjectSimpleSpel2) o;
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
