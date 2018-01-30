package com.virb.clone.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Table(name="website")
@Component
public class Website {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="site_title")
	@NotNull(message="Title is required.")
	String title;

	@Column(name="site_link")
	@NotNull(message="Link is required.")
	String link;
	
	@Column(name="site_category")
	@NotNull(message="Please select a category.")
	String category;
	
	
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="account_id")
	private Account account;
	
	
	
//	List<String> categoryList;
		
	public Website(){
//		categoryList = new ArrayList<>();
//		
//		categoryList.add("Porfolio");
//		categoryList.add("Bussiness");
//		categoryList.add("Restaurant");
//		categoryList.add("Music");
//		categoryList.add("Organization");
//		categoryList.add("Personal");
//		categoryList.add("Other");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

//	public List<String> getCategoryList() {
//		return categoryList;
//	}
//
//	public void setCategoryList(List<String> categoryList) {
//		this.categoryList = categoryList;
//	}
//	
	
}
