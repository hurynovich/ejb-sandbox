package io.github.hurynovich.ejb.first.alpha;

import javax.ejb.Local;
import javax.ejb.Remote;

/**
 * This is very simple "Hello world" EJB interface.
 */
@Local @Remote
public interface HelloWorldBean {
    String sayHello();
}
