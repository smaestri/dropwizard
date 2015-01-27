package com.example.todo.view;

import java.util.List;

import com.example.todo.core.Book;
import com.example.todo.core.User;

import io.dropwizard.views.View;

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
