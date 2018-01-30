package com.virb.clone.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Entity
@Table(name="account")
@Component
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="first_name")
	@NotNull(message="First name is require.")
	String firstName;

	@Column(name="last_name")
	@NotNull(message="Last name is require.")
	String lastName;
	
	//@Pattern(regexp="^[a-zA-Z0-9]*[@]{1}[a-zA-Z]*[.]{1}[a-zA-Z]{3}", message="Must be a valid website.") //for use easy password
	@Column(name="email")
	@NotNull(message="Email cannot be null!")
	private String email;

	@Column(name="password")
	//@Pattern(regexp="^.*(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", //remove for faster testing
			//message="Password must contain a number, letter, uppercase letter, and one of @$#%^&+=")
	@NotNull(message="Password is required!")
	//@Size(min=8, max=12, message="Password must be between 8 to 12 character long.") //remove for faster testing
	private String password;
	
	@OneToMany(mappedBy="account", cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	private List<Website> website;
	
//	boolean stayLogIn;
	
	public Account() {
		
	}
	
	public Account(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public List<Website> getWebsite() {
		return website;
	}

	public void setWebsite(List<Website> website) {
		this.website = website;
	}
	
	public void addWebsite(Website tempWebsite) {
		if(website == null) {
			website = new ArrayList<>();
		}
		
		website.add(tempWebsite);
		tempWebsite.setAccount(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
//	public boolean isStayLogIn() {
//		return stayLogIn;
//	}
//
//	public void setStayLogIn(boolean stayLogIn) {
//		this.stayLogIn = stayLogIn;
//	}

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
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Account [email=" + email + ", password=" + password + ", stayLogIn=" + "]";
	}
	
}
