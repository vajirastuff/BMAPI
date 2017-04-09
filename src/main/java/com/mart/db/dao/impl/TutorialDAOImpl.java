package com.mart.db.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mart.db.dao.TutorialDAO;
import com.mart.db.model.Tutorial;
import com.mart.db.model.User;

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
		Session session = this.sessionFactory.getCurrentSession();
		session.update(T);
		logger.info("Tutorial Update Successfully..!");
	}

	@Override
	public List<Tutorial> ListTutorial() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Tutorial> tutoriallist = session.createQuery("from Tutorial").list();
		for(Tutorial u : tutoriallist){
			logger.info("Tutorial List::"+u);
		}
		return null;
	}

	@Override
	public Tutorial getTutorialIDByHeader(String Header) {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.getCurrentSession();		
		Tutorial p = (Tutorial) session.load(Tutorial.class, new String(Header));
		logger.info("Tutorial loaded successfully, Tutorial details="+p);
		
		return p;
		
	}

	@Override
	public Tutorial getTutorialIDByDescription(String Search) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();		
		Tutorial p = (Tutorial) session.load(Tutorial.class, new String(Search));
		logger.info("Tutorial loaded successfully, Tutorial details="+p);
		
		return p;
	}

	@Override
	public boolean RemoveTurorialByID(int ID) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Tutorial u = (Tutorial) session.load(Tutorial.class, new Integer(ID));
		if(null != u){
			session.delete(u);
			logger.info("Tutorial deleted successfully, Tutorial details="+u);
			return true;
		}
		
		
		return false;
	}

}
