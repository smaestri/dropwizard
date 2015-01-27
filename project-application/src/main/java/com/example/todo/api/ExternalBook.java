package com.example.todo.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class ExternalBook {
    private long id;

    @Length(max = 3)
    private String titre;

    public ExternalBook() {
        // Jackson deserialization
    }

    public ExternalBook(long id, String titre) {
        this.id = id;
        this.titre = titre;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}