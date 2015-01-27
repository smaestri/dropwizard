package com.example.todo.resources;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import io.dropwizard.views.View;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.todo.core.User;
import com.example.todo.db.UserDAO;
import com.example.todo.view.UserFormView;
import com.example.todo.view.UserListView;
import com.google.common.base.Optional;
import com.google.inject.Inject;

@Path("/users")
public class UserResource {
	private UserDAO userDAO;

	@Inject
	public UserResource(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Path("/list")
		 @Produces(MediaType.TEXT_HTML)
		 @UnitOfWork
		 @GET
		 public UserListView listUsers() {
		List<User> users = userDAO.findAll();
		return new UserListView(users);
	}
	
	@Path("/edit")
	@Produces(MediaType.TEXT_HTML)
	@UnitOfWork
	@GET
	public View editUser(@QueryParam(value="id") Long id) {
		Optional<User> user = userDAO.findById(id);
		if(user.isPresent()) {
			return new UserFormView(user.get());
		} else {
			return listUsers();
		}
	}
	
	@Path("/edit")
	@Produces(MediaType.TEXT_HTML)
	@UnitOfWork
	@POST
	public View updateUser(
			@FormParam(value = "id") Long id,
			@FormParam(value = "firstName") String firstName,
			@FormParam(value = "lastName") String lastName) {
		Optional<User> user = userDAO.findById(id);
		if(user.isPresent()) {
			User userToUpdate = user.get();
			userToUpdate.setFirstName(firstName);
			userToUpdate.setLastName(lastName);
			userDAO.update(userToUpdate);
		}
		return listUsers();
	}
	
	@Path("/create")
	@Produces(MediaType.TEXT_HTML)
	@UnitOfWork
	@GET
	public View editUser() {
		return new UserFormView();
	}
	
	@Path("/create")
	@Produces(MediaType.TEXT_HTML)
	@UnitOfWork
	@POST
	public View createUser(
			@FormParam(value = "firstName") String firstName,
			@FormParam(value = "lastName") String lastName) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		userDAO.create(user);
		return listUsers();
	}
	
	@Path("/delete")
	@Produces(MediaType.TEXT_HTML)
	@UnitOfWork
	@GET
	public View deleteUser(@QueryParam(value="id") Long id) {
		Optional<User> user = userDAO.findById(id);
		if(user.isPresent()) {
			userDAO.delete(user.get());
		} 
		return listUsers();
	}
}
