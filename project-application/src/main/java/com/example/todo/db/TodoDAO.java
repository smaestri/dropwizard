package com.example.todo.db;

import com.example.todo.core.Todo;
import com.example.todo.core.Todo;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import com.example.todo.core.Todo;

import java.util.List;

public class TodoDAO extends AbstractDAO<Todo> {
    public TodoDAO(SessionFactory factory) {
        super(factory);
    }

//    public Optional<Todo> findById(Long id) {
//        return Optional.fromNullable(get(id));
//    }

    public Todo create(Todo todo) {
        return persist(todo);
    }

    public List<Todo> findAll() {
        return list(namedQuery("Todo.findAll"));
    }
}
