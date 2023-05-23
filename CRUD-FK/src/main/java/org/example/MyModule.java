package org.example;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.example.dao.MyDAO;
import org.example.resource.MyResource;
import org.hibernate.SessionFactory;
import javax.inject.Singleton;

public class MyModule extends AbstractModule {

    private final SessionFactory sessionFactory;

    public MyModule(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    protected void configure() {
        bind(MyResource.class).in(Singleton.class);
    }

    @Provides
    public MyDAO provideMyDAO() {
        return new MyDAO(sessionFactory);
    }
}
