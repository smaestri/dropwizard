package com.example.todo.view;

import java.util.List;
import com.example.todo.core.User;

import io.dropwizard.views.View;

public class UserListView extends View {
	private final List<User> users;
	
	public UserListView(List<User> users) {
		super("userList.ftl");
		this.users = users;
	}
	
	public List<User> getUsers() {
		return users;
	}
}
