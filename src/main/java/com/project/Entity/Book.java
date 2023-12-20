package com.project.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid;
     
    private String email;
     
    private String password;
     
    @Column(name = "full_name")
    private String fullName;
         
    //private boolean enabled;
     
    @OneToOne(cascade = CascadeType.ALL)
	private Role roles;

	public Book(Integer bid, String email, String password, String fullName, Role roles) {
		super();
		this.bid = bid;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.roles = roles;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", email=" + email + ", password=" + password + ", fullName=" + fullName
				+ ", roles=" + roles + "]";
	}

	
	
}
