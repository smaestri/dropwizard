TODOLIST with dropwizard-guice-freemarker
========================

A complete dropwizard example for using Guice, freemarker and Hibernate.

Inside project-application module :

1 - Init H2 DB

```
mvn clean package
java -jar target/project-application-1.0-SNAPSHOT.jar db migrate todo.yml
```

2- Launch Server

```
java -jar target/project-application-1.0-SNAPSHOT.jar server todo.yml
```

3 - Query with REST :

- Get TODOS:
```
GET method : http://localhost:8080/todo
```

- Add TODO :

POST : send JSON to same URL in POST
```
 { 
  "libelle": "test"
}
```

