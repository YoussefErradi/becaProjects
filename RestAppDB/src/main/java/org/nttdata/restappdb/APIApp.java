package org.nttdata.restappdb;



import org.nttdata.restappdb.services.UserServiceImpl;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/api")
public class APIApp extends Application {
    private Set<Object> singletons;

    public APIApp() {
        singletons = new HashSet<Object>();


        singletons.add(new UserServiceImpl());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
