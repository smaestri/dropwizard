TODOLIST with dropwizard-guice-freemarker
========================

A complete dropwizard example for using Guice, freemarker and Hibernate.

Inside project-application module :

1 - Intit H2 DB

```
mvn clean package
java -jar target/project-application-1.0-SNAPSHOT.jar db migrate hello-world.yml
```

2- Launch Server

```
java -jar target/project-application-1.0-SNAPSHOT.jar server hello-world.yml
```

3 - Query with REST :

Get TOSDOS:
```
GET method : http://localhost:8080/todo
```

Add TODO

```
POST : send JSON to same URL in POST
 { 
  "libelle": "test"
}
```

