package com.example.todo.db;

import com.example.todo.api.ExternalTodo;
import com.example.todo.core.Todo;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class TodoDAO extends AbstractDAO<Todo> {

    @Inject
    public TodoDAO(SessionFactory factory) {
        super(factory);
    }

//    public Optional<Todo> findById(Long id) {
//        return Optional.fromNullable(get(id));
//    }

    public Todo create(ExternalTodo etodo) {
        Todo todo = new Todo();
        todo.setLibelle(etodo.getLibelle());
        return persist(todo);
    }

    public List<Todo> findAll() {
        return list(namedQuery("Todo.findAll"));
    }
}
