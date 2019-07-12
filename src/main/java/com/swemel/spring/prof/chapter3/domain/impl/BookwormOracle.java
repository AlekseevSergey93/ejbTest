package com.swemel.spring.prof.chapter3.domain.impl;

import com.swemel.spring.prof.chapter3.domain.Oracle;

public class BookwormOracle implements Oracle {

    private Encyclopedia encyclopedia;

    public String defineMeaningOfLife() {
        return "Encyclopedias are а waste of money - "
                + "go see the world instead";
    }

    public void setEncyclopedia(Encyclopedia encyclopedia) {
        this.encyclopedia = encyclopedia;
    }
}
