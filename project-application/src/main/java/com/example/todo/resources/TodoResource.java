package com.example.todo.resources;

import com.example.todo.core.Book;
import com.example.todo.core.Todo;
import com.example.todo.db.BookDAO;
import com.example.todo.db.TodoDAO;
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

    private final TodoDAO todoDao;
    private final BookDAO bookDAO;

    @Inject
    public TodoResource(TodoDAO todoDao, BookDAO bookDAO) {
        this.todoDao = todoDao;
        this.bookDAO = bookDAO;
    }

    @GET
    @Path("/list")
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    public TodoListView listTodo() {
        List<Todo> all = todoDao.findAll();
        return new TodoListView(all);
    }

//    @GET
//    @Path("{idBook}")
//    @UnitOfWork
//    @Produces(MediaType.TEXT_HTML)
//    public TodoView listTodoFromBook(@PathParam("id") int idBook) {
//        List<Todo> all = todoDao.getTasksFromBook(idBook);
//        return new TodoView(all);
//    }

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
    public View createTodo(/*ExternalTodo etodo*/@FormParam("idBook") Long idBook, @FormParam("libelle") String libelle) {
        Todo todo = new Todo();
        todo.setLibelle(libelle);
        Optional<Book> book = this.bookDAO.findById(idBook);
        if (book.isPresent()) {
            todo.setBook(book.get());
            todoDao.create(todo);
        }
        return listTodo();
    }

}