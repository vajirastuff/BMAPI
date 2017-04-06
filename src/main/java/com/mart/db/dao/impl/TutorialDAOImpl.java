package com.mart.db.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mart.db.dao.TutorialDAO;
import com.mart.db.model.Tutorial;

@Repository
public class TutorialDAOImpl implements TutorialDAO {

	private static final Logger logger = LoggerFactory.getLogger(TutorialDAOImpl.class);
	private SessionFactory sessionFactory;
	
	public void Setsessionfactory(SessionFactory sf)
	{
		this.sessionFactory = sf;
	}
	
	@Override
	public void addTutorialID(Tutorial T) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(T);
		logger.info("Tutorial Added Successfully..! " + T);
	}

	@Override
	public void updateTotorial(Tutorial T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tutorial> ListTutorial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTutorialIDByHeader(String Header) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTutorialIDByDescription(String Search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean RemoveTurorialByID(int ID) {
		// TODO Auto-generated method stub
		return false;
	}

}
