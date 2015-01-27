package com.example.todo;

import com.example.todo.core.Book;
import com.example.todo.core.Todo;
import com.example.todo.module.TodoModule;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class TodoApplication extends Application<TodoConfiguration> {

    private final HibernateBundle<TodoConfiguration> hibernateBundle =
            new HibernateBundle<TodoConfiguration>(Todo.class, Book.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(TodoConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    public static void main(String[] args) throws Exception {
        new TodoApplication().run(args);
    }

    @Override
    public String getName() {
        return "todo";
    }

    @Override
    public void initialize(Bootstrap<TodoConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<TodoConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(TodoConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });

        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(new ViewBundle());
        GuiceBundle<TodoConfiguration> guiceBundle = GuiceBundle.<TodoConfiguration>newBuilder()
                .addModule(new TodoModule(hibernateBundle))
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(TodoConfiguration.class)
                        //  .setInjectorFactory( new GovernatorInjectorFactory() )
                .build();
        bootstrap.addBundle(guiceBundle);
        bootstrap.addBundle(new AssetsBundle("/assets/css", "/css", null, "css"));
        bootstrap.addBundle(new AssetsBundle("/assets/js", "/js", null, "js"));
        bootstrap.addBundle(new AssetsBundle("/assets/fonts", "/fonts", null, "fonts"));
    }

    @Override
    public void run(TodoConfiguration configuration,
                    Environment environment) {
    }

}