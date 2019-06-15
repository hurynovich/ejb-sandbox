package io.github.hurynovich.ejb.first.alpha;

import javax.ejb.Remote;

/**
 * This EJB retrieves internal server (in my case Wildfly) resource
 */
@Remote
public interface ServerResourceInjectionBean {
    String getAppName();
}
