package com.example.todo.core;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@NamedQueries({
        @NamedQuery(
                name = "Book.findAll",
                query = "SELECT b FROM Book b"
        )
})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Todo> listTask;

    @Column(name = "titre", nullable = false)
    private String titre;

    public List<Todo> getListTask() {
        return listTask;
    }

    public void setListTask(List<Todo> listTask) {
        this.listTask = listTask;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void addTodo(Todo todo) {
        if (this.listTask == null) {
            this.listTask = new ArrayList<Todo>();
        }
        this.listTask.add(todo);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
