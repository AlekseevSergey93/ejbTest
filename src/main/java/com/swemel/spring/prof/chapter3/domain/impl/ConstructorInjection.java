package com.swemel.spring.prof.chapter3.domain.impl;

import com.swemel.spring.prof.chapter3.domain.impl.Dependency;

public class ConstructorInjection {

    private Dependency dependency;

    public ConstructorInjection(Dependency dependency) {
        this.dependency = dependency;
    }

    public String toString() {
        return dependency.toString();
    }
}
