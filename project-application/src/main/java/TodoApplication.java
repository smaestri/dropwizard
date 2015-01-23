import com.example.todo.core.Todo;
import com.example.todo.db.TodoDAO;
import com.example.todo.resources.TodoResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.hibernate.SessionFactory;

public class TodoApplication extends Application<TodoConfiguration> {

    private final HibernateBundle<TodoConfiguration> hibernateBundle =
            new HibernateBundle<TodoConfiguration>(Todo.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(TodoConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    public static void main(String[] args) throws Exception {
        new TodoApplication().run(args);
    }

    @Override
    public String getName() {
        return "todo";
    }

    @Override
    public void initialize(Bootstrap<TodoConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<TodoConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(TodoConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(TodoConfiguration configuration,
                    Environment environment) {

        SessionFactory sessionFactory = hibernateBundle.getSessionFactory();
        TodoDAO dao = new TodoDAO(sessionFactory);

        final TodoResource resource = new TodoResource(dao);
//        final TemplateHealthCheck healthCheck =
//                new TemplateHealthCheck(configuration.getTemplate());
//        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }

}