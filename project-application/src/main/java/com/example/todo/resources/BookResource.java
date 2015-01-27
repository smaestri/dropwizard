package com.example.todo.resources;

import com.example.todo.core.Book;
import com.example.todo.core.Todo;
import com.example.todo.core.User;
import com.example.todo.db.BookDAO;
import com.example.todo.db.TodoDAO;
import com.example.todo.view.BookFormView;
import com.example.todo.view.BookListView;
import com.example.todo.view.UserFormView;
import com.example.todo.view.UserListView;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.views.View;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    private final BookDAO bookDAO;
    private final TodoDAO todoDAO;

    @Inject
    public BookResource(BookDAO bookDAO, TodoDAO todoDAO) {
        this.bookDAO = bookDAO;
        this.todoDAO = todoDAO;
    }

    @GET
    @UnitOfWork
    @Path("/list")
    @Produces(MediaType.TEXT_HTML)
    public BookListView listAll() {
        List<Book> all = bookDAO.findAll();
        return new BookListView(all);
    }

    @Path("/edit")
    @Produces(MediaType.TEXT_HTML)
    @UnitOfWork
    @GET
    public View editBook(@QueryParam(value="id") Long id) {
        Optional<Book> book = bookDAO.findById(id);
        if(book.isPresent()) {
            return new BookFormView(book.get());
        } else {
            return listAll();
        }
    }

    @Path("/edit")
    @Produces(MediaType.TEXT_HTML)
    @UnitOfWork
    @POST
    public View updateBook() {
        Optional<Book> book = bookDAO.findById(b.getId());
        if(book.isPresent()) {
            // TODO : UPDATE BOOK
        }
        return listAll();
    }

    @Path("/create")
    @Produces(MediaType.TEXT_HTML)
    @UnitOfWork
    @GET
    public View createBook() {
        return new BookFormView();
    }

    @Path("/create")
    @Produces(MediaType.TEXT_HTML)
    @POST
    @UnitOfWork
    public View createBook(@FormParam("listeTodo") List<String> listeTodos, @FormParam("titre")  String titre) {
        // creation book et ajout des todos
        Book book = new Book();
        book.setTitre(titre);

        for (String idTodo : listeTodos) {
            Optional<Todo> otodo = this.todoDAO.findById(Long.valueOf(idTodo));
            if (otodo.isPresent())
                book.addTodo(otodo.get());
        }
        bookDAO.create(book);
        return listAll();
    }

}