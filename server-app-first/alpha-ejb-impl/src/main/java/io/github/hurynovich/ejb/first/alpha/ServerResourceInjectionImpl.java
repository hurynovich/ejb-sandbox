package io.github.hurynovich.ejb.first.alpha;

import javax.annotation.Resource;
import javax.ejb.Stateless;

/**
 * This retrieves JNDI resource via @{@link Resource} annotation.<br>
 * This resource is just {@link String} with ear application name.
 */
@Stateless(name = "ServerResourceInjectionEJB")
public class ServerResourceInjectionImpl implements ServerResourceInjectionBean{
    /**
     * For Wildfly server this resource "java:app/AppName" is defined automatically.
     * But for other servers this resource must be set up manually in admin console.
     */
    @Resource(lookup = "java:app/AppName")
    String appName;

    @Override
    public String getAppName() {
            return appName;
    }
}
