package com.example.todo.view;

import com.example.todo.core.Book;
import io.dropwizard.views.View;

import java.util.List;

public class BookListView extends View {
    private final List<Book> books;

    public BookListView(List<Book> books) {
        super("bookList.ftl");
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
