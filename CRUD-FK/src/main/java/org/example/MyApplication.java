package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.example.entity.MyEntity;
import org.example.resource.MyResource;

public class MyApplication extends Application<MyConfiguration> {

    private final HibernateBundle<MyConfiguration> hibernateBundle = new HibernateBundle<MyConfiguration>(
            MyEntity.class
    ) {
        @Override
        public DataSourceFactory getDataSourceFactory(MyConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    public static void main(final String[] args) throws Exception {

      new MyApplication().run(args);

    }

    @Override
    public void initialize(final Bootstrap<MyConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final MyConfiguration configuration, final Environment environment) {
        final Injector injector = Guice.createInjector(new MyModule(hibernateBundle.getSessionFactory()));
        final MyResource resource = injector.getInstance(MyResource.class);
        environment.jersey().register(resource);
    }
}
