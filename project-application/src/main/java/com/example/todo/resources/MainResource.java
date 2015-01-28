package com.example.todo.resources;

import com.example.todo.view.MainView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class MainResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public MainView listAll() {
        return new MainView();
    }

}