package com.example.todo.db;

import com.example.todo.core.Book;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookDAO extends AbstractDAO<Book> {

    @Inject
    public BookDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Book> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Book create(Book book) {
        return persist(book);
    }

    public List<Book> findAll() {
        return list(namedQuery("Book.findAll"));
    }

//    public Book getTasksFromBook(int bookId) {
//        Criteria criteria = this.currentSession().createCriteria(Todo.class);
//        return criteria.list();
//    }
}
