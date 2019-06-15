package io.github.hurynovich.ejb.first.alpha;

import javax.ejb.Local;
import javax.ejb.Remote;

/**
 * This is very simple "Hello world" EJB interface.
 * It just returns greeting message.
 */
@Remote
public interface HelloWorldBean {
    String sayHello();
}
