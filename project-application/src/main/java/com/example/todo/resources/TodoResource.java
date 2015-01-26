package com.example.todo.resources;

import com.example.todo.api.ExternalTodo;
import com.example.todo.core.Todo;
import com.example.todo.db.TodoDAO;
import com.example.todo.view.TodoView;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/todo")
@Produces(MediaType.APPLICATION_JSON)
public class TodoResource {

    private final TodoDAO todoDao;

    @Inject
    public TodoResource(TodoDAO todoDao) {
        this.todoDao = todoDao;
    }

    /**
     * Get todos for freemarker
     *
     * @return
     */
    @GET
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    public TodoView listTodo() {
        List<Todo> all = todoDao.findAll();
        return new TodoView(all);
    }

    @POST
    @UnitOfWork
    public Todo createTodo(ExternalTodo todo) {
        return todoDao.create(todo);
    }
}