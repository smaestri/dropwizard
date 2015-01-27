package com.example.todo.db;

import com.example.todo.core.User;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDAO extends AbstractDAO<User> {

    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<User> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Optional<User> create(User user) {
        return Optional.fromNullable(persist(user));
    }

    public List<User> findAll() {
        return list(namedQuery("com.example.todo.core.User.findAll"));
    }
}
