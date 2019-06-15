package io.github.hurynovich.ejb.first.alpha;

import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless(name = "HelloWorldBean")
public class HelloWorldBeanImpl implements HelloWorldBean, Serializable {

    @Override
    public String sayHello() {
        return  "Hello EJB world!";
    }
}
