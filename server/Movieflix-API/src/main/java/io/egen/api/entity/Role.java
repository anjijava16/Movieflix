package io.egen.api.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
	@NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE r.name=:pName")
})
public class Role {
	
	@Id
	private String id;
	
	@Column(unique=true)
	private String name;
	
	public Role(){
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
