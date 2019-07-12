package com.swemel.spring.prof.chapter3.services;

import com.swemel.spring.prof.chapter2.MessageProvider;
import com.swemel.spring.prof.chapter3.domain.impl.ConstructorConfusion;
import com.swemel.spring.prof.chapter3.domain.impl.InjectRef;
import com.swemel.spring.prof.chapter3.spel.InjectSimpleSpel;
import com.swemel.spring.prof.chapter3.spel.InjectSimpleSpel2;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("xml-bean-factory-config.xml");
        ctx.refresh();
        MessageProvider messageProvider = ctx.getBean("provider3", MessageProvider.class);
        System.out.println(messageProvider.getMessage());
        ConstructorConfusion constructorConfusion = ctx.getBean("constructorConfusion", ConstructorConfusion.class);
        InjectSimpleSpel simple = ctx.getBean("injectSimpleSpel", InjectSimpleSpel.class);
        System.out.println(simple + "\n");
        InjectSimpleSpel2 simple2 = ctx.getBean("injectSimpleSpel2", InjectSimpleSpel2.class);
        System.out.println(simple2);
        InjectRef injectRef = ctx.getBean("injectRef", InjectRef.class);
        System.out.println(injectRef);

        ctx.close();
    }
}
