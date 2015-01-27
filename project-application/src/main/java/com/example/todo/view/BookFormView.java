package com.example.todo.view;

import com.example.todo.core.Book;
import com.google.common.base.Optional;

import io.dropwizard.views.View;

public class BookFormView extends View {
    private final Optional<Book> Book;

    public BookFormView() {
        super("bookForm.ftl");
        this.Book = Optional.absent();
    }

    public BookFormView(Book Book) {
        super("bookForm.ftl");
        this.Book = Optional.fromNullable(Book);
    }

    public Optional<Book> getBook() {
        return Book;
    }
}
