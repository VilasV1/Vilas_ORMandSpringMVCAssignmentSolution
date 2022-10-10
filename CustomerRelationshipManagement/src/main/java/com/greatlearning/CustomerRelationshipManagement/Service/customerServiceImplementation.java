package com.greatlearning.CustomerRelationshipManagement.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.CustomerRelationshipManagement.Entity.customerEntity;

@Repository
public class customerServiceImplementation implements customerService {

	private SessionFactory sessionFactory;

	private Session session;

	@Autowired
	customerServiceImplementation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	@Transactional
	public List<customerEntity> findAll() {

		Transaction tx = session.beginTransaction();

	
		List<customerEntity> customers = session.createQuery("from customerEntity").list();

		tx.commit();

		return customers;
	}

	@Transactional
	public customerEntity findById(int id) {

		customerEntity customer=new customerEntity();

		Transaction tx = session.beginTransaction();

		
		customer = session.get(customerEntity.class, id);

		tx.commit();

		return customer;
	}

	@Transactional
	public void save(customerEntity Customer) {

		Transaction tx = session.beginTransaction();

		session.saveOrUpdate(Customer);

		tx.commit();

	}

	@Transactional
	public void deleteById(int id) {

		Transaction tx = session.beginTransaction();

		
		customerEntity customer = session.get(customerEntity.class, id);

		
		session.delete(customer);

		tx.commit();

	}

}
