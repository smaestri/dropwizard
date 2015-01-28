package com.example.todo.view;

import com.example.todo.core.Todo;
import com.google.common.base.Optional;
import io.dropwizard.views.View;

public class TodoFormView extends View {

    private final Optional<com.example.todo.core.Todo> todo;

    public TodoFormView() {
        super("todoForm.ftl");
        this.todo = Optional.absent();
    }

    public TodoFormView(Todo todo) {
        super("todoForm.ftl");
        this.todo = Optional.fromNullable(todo);
    }

    public Optional<Todo> getTodo() {
        return todo;
    }
}
