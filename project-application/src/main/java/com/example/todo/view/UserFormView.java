package com.example.todo.view;

import com.example.todo.core.User;
import com.google.common.base.Optional;
import io.dropwizard.views.View;

public class UserFormView extends View {
    private final Optional<User> user;

    public UserFormView() {
        super("userForm.ftl");
        this.user = Optional.absent();
    }

    public UserFormView(User user) {
        super("userForm.ftl");
        this.user = Optional.fromNullable(user);
    }

    public Optional<User> getUser() {
        return user;
    }
}
