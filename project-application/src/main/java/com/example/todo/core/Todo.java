package com.example.todo.core;

import javax.persistence.*;

@Entity
@Table(name = "todo")
@NamedQueries({
        @NamedQuery(
                name = "Todo.findAll",
                query = "SELECT p FROM Todo p"
        )
})
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "libelle", nullable = false)
    private String libelle;

    @ManyToOne()
    @JoinColumn(name = "ID_BOOK", nullable = false)
    private Book book;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
