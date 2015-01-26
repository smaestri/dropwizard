package com.example.todo.module;

import com.example.todo.TodoConfiguration;
import com.example.todo.db.TodoDAO;
import com.google.inject.Binder;
import com.google.inject.Provides;
import io.dropwizard.hibernate.HibernateBundle;

public class TodoModule implements com.google.inject.Module {

    HibernateBundle<TodoConfiguration> hibernateBundle;

    public TodoModule(HibernateBundle<TodoConfiguration> hibernateBundle) {
        this.hibernateBundle = hibernateBundle;
    }

    @Override
    public void configure(Binder binder) {
    }

    @Provides
    public TodoDAO getDAO() {
        return new TodoDAO(hibernateBundle.getSessionFactory());
    }

}
