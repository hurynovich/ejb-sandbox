package io.github.hurynovich.helloejb.foo.simple;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.*;

@Slf4j
@javax.ejb.Stateless(name = "GreetingsEJB")
public class GreetingsBeanImpl implements GreetingsBean {

    private static volatile int counter;

    private final int id = nextNumber();

    public GreetingsBeanImpl() {
        log.info("New instance created " + getId());
    }

    @Override
    public String sayHello(String name){
        return "Hello " + name;
    }

    @Override
    public String slleep(int duration) {

        try {
            sleep(duration);
        } catch (InterruptedException e) {
            return "Fail";
        }
        return "Done in " + duration /1000.0 + " sec";
    }

    @Override
    public String getId() {
        return this.id + "";
    }

    private synchronized int nextNumber(){
        return counter++;
    }
}


