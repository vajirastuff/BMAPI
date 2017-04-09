package com.mart.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mart.db.dao.TutorialDAO;
import com.mart.db.model.Tutorial;
import com.mart.service.TutorialService;

public class TutorialServiceImpl implements TutorialService
{
	private TutorialDAO tutorialDAO;

	@Override
	@Transactional
	public void addTutorialID(Tutorial T) {
		// TODO Auto-generated method stub
		this.tutorialDAO.addTutorialID(T);
	}

	@Override
	@Transactional
	public void updateTotorial(Tutorial T) {
		// TODO Auto-generated method stub
		this.tutorialDAO.updateTotorial(T);
	}

	@Override
	@Transactional
	public List<Tutorial> ListTutorial() {
		// TODO Auto-generated method stub
		return tutorialDAO.ListTutorial();
	}

	@Override
	@Transactional
	public Tutorial getTutorialIDByHeader(String Header) {
		// TODO Auto-generated method stub
		return this.tutorialDAO.getTutorialIDByHeader(Header);
	}

	@Override
	@Transactional
	public Tutorial getTutorialIDByDescription(String Search) {
		// TODO Auto-generated method stub
		return this.tutorialDAO.getTutorialIDByDescription(Search);
	}

	@Override
	@Transactional
	public boolean RemoveTurorialByID(int ID) {
		// TODO Auto-generated method stub
		return this.tutorialDAO.RemoveTurorialByID(ID);
	}

	
	


}
