package com.example.todo.resources;

import com.example.todo.core.Book;
import com.example.todo.core.Todo;
import com.example.todo.db.BookDAO;
import com.example.todo.db.TodoDAO;
import com.example.todo.view.BookView;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;

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
    @Produces(MediaType.TEXT_HTML)
    public BookView listAll() {
        List<Book> all = bookDAO.findAll();
        return new BookView(all);
    }

    @POST
    @UnitOfWork
    public Book createBook(@FormParam("listeTodo") List<String> listeTodos, String titre) {
        // creation book et ajout des todos
        Book book = new Book();
        book.setTitre(titre);

        for (String idTodo : listeTodos) {
            Optional<Todo> otodo = this.todoDAO.findById(Long.valueOf(idTodo));
            if (otodo.isPresent())
                book.addTodo(otodo.get());
        }
        return bookDAO.create(book);
    }

}