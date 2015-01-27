package com.example.todo.view;

import com.example.todo.core.Book;
import io.dropwizard.views.View;

import java.util.List;

public class BookView extends View {

    private final List<Book> books;

    public BookView(List<Book> books) {
        super("book.ftl");
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

}
