package com.swemel.spring.prof.chapter3.domain.impl;

import com.swemel.spring.prof.chapter3.domain.Oracle;

public class InjectRef {

    private Oracle oracle;

    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
    }

    @Override
    public String toString() {
        return this.oracle.defineMeaningOfLife();
    }
}
