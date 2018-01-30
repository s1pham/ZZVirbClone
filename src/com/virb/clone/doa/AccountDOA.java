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

@Component
public class AccountDOA {

	@Autowired
	SessionFactory sessionFactory;
	
	List<Account> allAccount;
	
	
	public AccountDOA() {
		
	}
	
	@Transactional
	public List<Account> getAccounts() {
		Session session = sessionFactory.getCurrentSession();
		allAccount = new ArrayList<>();
		Query<Account> accountQuery = session.createQuery("from Account order by lastName");
		List<Account> account = accountQuery.getResultList();
		
		return account;
	}
	
	@Transactional
	public void addAccount(Account account) {
		Session session = sessionFactory.getCurrentSession();
		session.save(account);
	}
	
	@Transactional
	public Account getAccount(int id) {
		Session session = sessionFactory.getCurrentSession();
	    Account account = session.get(Account.class, id);
	    
	    return account;
	}
	
	@Transactional
	public boolean deleteAccount(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Account where id=:accountId");
		query.setParameter("accountId", id);
		
		int row = query.executeUpdate(); //return num of row affected
		
		if(row >= 1) return true;
		return false;
		
	}
	
	@Transactional
	public boolean loginAccount(Account account) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Account where id=:email and passowrd=:password");
		query.setParameter("accountId", account.getEmail());
		query.setParameter("password", account.getPassword());
		
		int row = query.executeUpdate(); //return num of row affected
		
		if(row >= 1) return true;
		
		System.out.println("Account was not found!!");
		return false;
		
	}
	
	
	private List<Account> searchAccount(String name) {
		Session session = sessionFactory.getCurrentSession();
		allAccount = new ArrayList<>();
		Query query = null;
		
		if(name!=null && name.trim().length()>0) {
			query = session.createQuery("from Account where lower(firstName) like :searchName or lower(lastName) like :searchName",
					Account.class);
			query.setParameter("searchName", name);
			
		}
		else {
			query = session.createQuery("from Account", Account.class);
		}
		
		List<Account> accounts = query.getResultList();
		
		return accounts;
	}
}
