package com.swemel.spring.prof.chapter3.domain.impl;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class FormatMessageReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        if (isFormatMessageMethod(method)) {
            String msg = (String) objects[0];
            return "<h2>" + msg + "</h2>";
        } else {
            throw new IllegalArgumentException("Unable to reimplement method " + method.getName());
        }
    }

    private boolean isFormatMessageMethod(Method method) {
        if (method.getGenericParameterTypes().length != 1) {
            return false;
        }

        if (! ("formatMessage".equals(method.getName()))) {
            return false;
        }

        if (method.getReturnType() != String.class) {
            return false;
        }

        if (method.getParameterTypes()[0] != String.class) {
            return false;
        }
        return true;
    }
}