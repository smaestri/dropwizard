package com.example.todo.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class ExternalTodo {
    private long id;

    @Length(max = 3)
    private String libelle;

    public ExternalTodo() {
        // Jackson deserialization
    }

    public ExternalTodo(long id, String lib) {
        this.id = id;
        this.libelle = lib;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getLibelle() {
        return libelle;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}