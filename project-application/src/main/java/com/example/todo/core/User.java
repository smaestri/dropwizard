package com.example.todo.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(
            name = "com.elthumsoft.dropwizard.authentication.core.User.findAll",
            query = "SELECT u FROM User u"
    ),
    @NamedQuery(
    		name = "com.elthumsoft.dropwizard.authentication.core.User.findByPseudo",
            query = "SELECT u FROM User u where pseudo=:pseudo"
	)
})
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "firstName", nullable = false)
    private String fisrtName;
	
	@Column(name = "lastName", nullable = false)
    private String lastName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
