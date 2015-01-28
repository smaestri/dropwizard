package com.example.todo.db;

import com.example.todo.core.Todo;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import java.util.List;

public class TodoDAO extends AbstractDAO<Todo> {

    @Inject
    public TodoDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Todo> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Todo create(Todo todo) {
        return persist(todo);
    }

    public List<Todo> findAll() {
        return list(namedQuery("Todo.findAll"));
    }

    public List<Todo> getTasksFromBook(int bookId) {
        Criteria criteria = this.currentSession().createCriteria(Todo.class);
        return criteria.list();
    }
}
