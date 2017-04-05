package com.mart.db.dao;

import java.util.List;

import com.mart.db.model.Tutorial;

public interface TutorialDAO 
{
	public void addTutorialID(Tutorial T);
	public void updateTotorial(Tutorial T);
	public List<Tutorial>ListTutorial();
	public int getTutorialIDByHeader(String Header);
	public int getTutorialIDByDescription(String Search);
	public boolean RemoveTurorialByID(int ID);
	
}
