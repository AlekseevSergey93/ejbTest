package com.swemel.spring.prof.chapter3.services;

import com.swemel.spring.prof.chapter3.domain.impl.ReplacementTarget;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementDemo {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context.xml");
        ctx.refresh();

        ReplacementTarget standardTarget = ctx.getBean("standardTarget", ReplacementTarget.class);
        ReplacementTarget replacementTarget = ctx.getBean("replacementTarget", ReplacementTarget.class);
        displayinfo(standardTarget);
        displayinfo(replacementTarget);

        ctx.close();

    }

    private static void displayinfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Thanks for playing, try again!"));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");
        for (int x = 0; x < 1000000; x++) {
            String out = target.formatMessage("No filter in my head");
        }
        stopWatch.stop();
        System.out.println("lOOOOOO invocations took: " + stopWatch.getTotalTimeMillis() + "ms");
    }
}
