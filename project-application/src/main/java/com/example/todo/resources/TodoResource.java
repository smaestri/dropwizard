package com.example.todo.resources;

import com.example.todo.core.Todo;
import com.example.todo.db.TodoDAO;
import com.example.todo.view.TodoView;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/todo")
@Produces(MediaType.APPLICATION_JSON)
public class TodoResource {

    private int id;
    private String libelle;

    private final TodoDAO todoDao;

    public TodoResource(TodoDAO todoDao) {
        this.todoDao = todoDao;
    }

    /**
     * Get todos for freemarker
     * @return
     */
    @GET
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    public TodoView listTodo() {
        //Connect to DB
       // List<ExternalTodo> listToto = new ArrayList<ExternalTodo>();

        List<Todo> all = todoDao.findAll();

        //Map TOTO entity to TODO api
//        List<Todo> all = todoDao.findAll();
//            for (Todo t : all){
//                ExternalTodo e = new ExternalTodo();
//                e.setLibelle(t.getLibelle());
//                e.setId(t.getId());
//                listToto.add(e);
//        }
        return new TodoView(all);
    }

    @POST
    @UnitOfWork
    public Todo createTodo(Todo todo) {
        return todoDao.create(todo);
    }

}