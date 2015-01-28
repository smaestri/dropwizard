package com.example.todo.resources;

import com.example.todo.core.Book;
import com.example.todo.core.Todo;
import com.example.todo.core.User;
import com.example.todo.db.BookDAO;
import com.example.todo.db.TodoDAO;
import com.example.todo.view.BookFormView;
import com.example.todo.view.TodoFormView;
import com.example.todo.view.TodoListView;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.views.View;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/todo")
@Produces(MediaType.APPLICATION_JSON)
public class TodoResource {

    private final TodoDAO todoDAO;
    private final BookDAO bookDAO;

    @Inject
    public TodoResource(TodoDAO todoDao, BookDAO bookDAO) {
        this.todoDAO = todoDao;
        this.bookDAO = bookDAO;
    }

    @GET
    @Path("/list")
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    public TodoListView listTodo() {
        List<Todo> all = todoDAO.findAll();
        return new TodoListView(all);
    }

    //@TODO : For Now, get tasks eagerly. Maybe better to get them with criteria to control SQL generation
//    @GET
//    @Path("{idBook}")
//    @UnitOfWork
//    @Produces(MediaType.TEXT_HTML)
//    public TodoView listTodoFromBook(@PathParam("id") int idBook) {
//        List<Todo> all = todoDao.getTasksFromBook(idBook);
//        return new TodoView(all);
//    }

    @Path("/edit")
    @Produces(MediaType.TEXT_HTML)
    @UnitOfWork
    @GET
    public View editTodo(@QueryParam(value = "id") Long id) {
        Optional<Todo> todo = todoDAO.findById(id);
        if (todo.isPresent()) {
            return new TodoFormView(todo.get());
        } else {
            return listTodo();
        }
    }

    @Path("/edit")
    @Produces(MediaType.TEXT_HTML)
    @UnitOfWork
    @POST
    public View editTodo(@FormParam(value = "id") Long id,
                           @FormParam(value = "libelle") String libelle) {
        Optional<Todo> book = todoDAO.findById(id);
        if (book.isPresent()) {
            Todo todoToUpdate = book.get();
            todoToUpdate.setLibelle(libelle);
        }
        return listTodo();
    }

    @Path("/create")
    @Produces(MediaType.TEXT_HTML)
    @UnitOfWork
    @GET
    public View prepareCreateTodo() {
        return new TodoFormView();
    }

    @Path("/create")
    @Produces(MediaType.TEXT_HTML)
    @POST
    @UnitOfWork
    public View createTodo(@FormParam("idBook") Long idBook, @FormParam("libelle") String libelle) {
        Todo todo = new Todo();
        todo.setLibelle(libelle);
        Optional<Book> book = this.bookDAO.findById(idBook);
        if (book.isPresent()) {
            todo.setBook(book.get());
            todoDAO.create(todo);
        }
        return listTodo();
    }

    @Path("/delete")
    @Produces(MediaType.TEXT_HTML)
    @UnitOfWork
    @GET
    public View deleteUser(@QueryParam(value = "id") Long id) {
        Optional<Todo> todo = todoDAO.findById(id);
        if (todo.isPresent()) {
            todoDAO.delete(todo.get());
        }
        return listTodo();
    }

}