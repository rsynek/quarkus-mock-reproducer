package org.example;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyBean {

    public MyClass getMyClass() {
        return new MyClass();
    }
}
