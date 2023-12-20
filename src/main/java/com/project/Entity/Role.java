package com.project.Entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rid;
     
    private String name;
     
    private String description;

	public Role(Integer id, String name, String description) {
		super();
		this.rid = id;
		this.name = name;
		this.description = description;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return rid;
	}

	public void setId(Integer id) {
		this.rid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Role [id=" + rid + ", name=" + name + ", description=" + description + "]";
	}
 
    // constructors, getter and setters are not shown for brevity  
    
}