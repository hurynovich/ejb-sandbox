package io.github.hurynovich.ejb.client;

import io.github.hurynovich.ejb.first.alpha.HelloWorldBean;
import lombok.extern.slf4j.Slf4j;

import javax.naming.*;

import java.util.Hashtable;

@Slf4j
public class Main {

    private static final String HTTP = "http";

    public static void main(String[] args) throws Exception {
        final Hashtable<String, String> jndiProperties = new Hashtable<>();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        if(Boolean.getBoolean(HTTP)) {
            //use HTTP based invocation. Each invocation will be a HTTP request
            jndiProperties.put(Context.PROVIDER_URL,"http://localhost:8080/wildfly-services");
        } else {
            //use HTTP upgrade, an initial upgrade requests is sent to upgrade to the remoting protocol
            jndiProperties.put(Context.PROVIDER_URL,"remote+http://localhost:8080");
        }
        final Context context = new InitialContext(jndiProperties);

        printContextContent(context);

        Context o = (Context) context.lookup("/simple-ejb-1.0-SNAPSHOT");
        printContextContent(o);

        HelloWorldBean bean = (HelloWorldBean) o.lookup("GreetingsEJB!io.github.hurynovich.helloejb.foo.simple.GreetingsBean");
        log.info("{}", bean.sayHello());
    }

    private static void printContextContent(Context context) throws NamingException {
        NamingEnumeration<NameClassPair> names = context.list("");
        if (!names.hasMore()){
            log.info("Context is empty.");
        }
        do {
            NameClassPair n = names.next();
            log.info("{}, {}", n.getNameInNamespace(), n.getClassName());
        } while (names.hasMore());
    }
}
