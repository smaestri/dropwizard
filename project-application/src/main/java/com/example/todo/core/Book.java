package com.example.todo.core;

import java.util.List;

public class Book {

    private List<Todo> listTask;
    private User user;

    public List<Todo> getListTask() {
        return listTask;
    }

    public void setListTask(List<Todo> listTask) {
        this.listTask = listTask;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
