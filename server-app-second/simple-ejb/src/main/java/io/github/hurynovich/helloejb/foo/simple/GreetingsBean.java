package io.github.hurynovich.helloejb.foo.simple;

import javax.ejb.Remote;

@Remote
public interface GreetingsBean {
    String sayHello(String name);
    String slleep(int duration);
    String getId();
}
