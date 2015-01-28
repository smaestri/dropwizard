package com.example.todo.view;

import com.example.todo.core.Todo;
import io.dropwizard.views.View;

import java.util.List;

public class TodoListView extends View {
    private final List<Todo> todos;

    public TodoListView(List<Todo> todos) {
        super("todoList.ftl");
        this.todos = todos;
    }

    public List<Todo> getTodos() {
        return todos;
    }
}
