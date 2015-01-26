package com.example.todo.view;

import com.example.todo.core.Todo;
import io.dropwizard.views.View;

import java.util.List;

public class TodoView extends View {

    private final List<Todo> todos;

    public TodoView(List<Todo> todos) {
        super("todo.ftl");
        this.todos = todos;
    }

    public List<Todo> getTodos() {
        return todos;
    }

}
