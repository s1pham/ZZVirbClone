package com.virb.clone.doa;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.virb.clone.entity.Account;
import com.virb.clone.entity.Website;

@Component
public class WebsiteDOA {

	@Autowired
	SessionFactory sessionFactory;
	
	Session session;
	List<Website> websites;
	
	
	public WebsiteDOA() {
		
		
		
	}
	
	@Transactional
	public List<Website> getWebsites() {
		session = sessionFactory.getCurrentSession();
		websites = new ArrayList<>();
		Query<Website> accountQuery = session.createQuery("from Website order by title");
		websites = accountQuery.getResultList();
		
		return websites;
	}
	
	@Transactional
	public boolean addWebsite(Website website) {
		session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(website);
		return true;
	}
	
	@Transactional
	public Website getWebsite(String title) {
		session = sessionFactory.getCurrentSession();
	    Website website = session.get(Website.class, title);
	    
	    return website;
	}
	
	@Transactional
	public boolean deleteAccount(String link) {
		session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Website where id=:websiteLink");
		query.setParameter("websiteLink", link);
		
		int row = query.executeUpdate(); //return num of row affected
		
		if(row >= 1) return true;
		return false;
		
	}
	
	private List<Website> searchAccount(String name) {
		session = sessionFactory.getCurrentSession();
		websites = new ArrayList<>();
		Query query = null;
		
		if(name!=null && name.trim().length()>0) {
			query = session.createQuery("from Website where lower(title) like :searchName",
					Account.class);
			query.setParameter("searchName", name);
			
		}
		else {
			query = session.createQuery("from Website", Account.class);
		}
		
		websites = query.getResultList();
		
		return websites;
	}
}
