package com.example.todo.db;

import java.util.List;

import org.hibernate.SessionFactory;

import com.example.todo.core.User;
import com.google.common.base.Optional;
import com.google.inject.Inject;

import io.dropwizard.hibernate.AbstractDAO;

public class UserDAO extends AbstractDAO<User> {

	@Inject
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
