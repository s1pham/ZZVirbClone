package com.virb.clone.entity;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CombineAccountWebsite {

	@NotNull(message="First name is require.")
	String firstName;

	@NotNull(message="Last name is require.")
	String lastName;
	
	@Pattern(regexp="^[a-zA-Z0-9]*[@]{1}[a-zA-Z]*[.]{1}[a-zA-Z]{3}", message="Must be a valid website.")
	@NotNull(message="Email cannot be null!")
	private String email;
	
	//@Pattern(regexp="^.*(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", 
			//message="Password must contain a number, letter, uppercase letter, and one of @$#%^&+=") //to use easy password for testing
	@NotNull(message="Password is required!")
	@Size(min=8, max=12, message="Password must be between 8 to 12 character long.")
	private String password;
	
	@NotNull(message="Title is required.")
	String title;
	
	@NotNull(message="Link is required.")
	String link;
	
	@NotNull(message="Please select a category.")
	String category;
	
	List<String> categoryList;
	
	public CombineAccountWebsite(){
		categoryList = new ArrayList<>();
		
		categoryList.add("Porfolio");
		categoryList.add("Bussiness");
		categoryList.add("Restaurant");
		categoryList.add("Music");
		categoryList.add("Organization");
		categoryList.add("Personal");
		categoryList.add("Other");
	}

	
	boolean stayLogIn;
	
	public boolean isStayLogIn() {
		return stayLogIn;
	}

	public void setStayLogIn(boolean stayLogIn) {
		this.stayLogIn = stayLogIn;
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
		return "Website [title=" + title + ", link=" + link + ", category=" + category + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}
}
