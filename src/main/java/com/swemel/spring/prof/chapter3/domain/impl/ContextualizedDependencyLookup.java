package com.swemel.spring.prof.chapter3.domain.impl;

import com.swemel.spring.prof.chapter3.domain.Container;
import com.swemel.spring.prof.chapter3.domain.ManagedComponent;

public class ContextualizedDependencyLookup implements ManagedComponent {

    private Dependency dependency;

    public void performLookup(Container container) {
        this.dependency = (Dependency)container.getDependency("myDependency");
    }

    public String toString() {
        return dependency.toString();
    }
}
