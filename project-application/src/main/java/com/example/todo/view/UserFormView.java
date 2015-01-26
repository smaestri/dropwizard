package com.example.todo.view;

import com.example.todo.core.User;

import io.dropwizard.views.View;

public class UserFormView extends View {
	private final User user;

	protected UserFormView(User user) {
		super("userForm.ftl");
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
