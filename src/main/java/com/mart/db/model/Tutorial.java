package com.mart.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tutorialmaster")
public class Tutorial extends BaseModel
{
	@Id
	@Column(name="Tutorial_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Tutorial_ID;
	
	private String Tutorial_Header;
	private String Tutorial_Description;
	
	
	public void SetTutorialHeader(String Tutorial_Header)
	{
		this.Tutorial_Header = Tutorial_Header;
	}
	
	public void SetTutorial_Description(String Tutorial_Description)
	{
		this.Tutorial_Description = Tutorial_Description;
	}
	
	public String GetTutorial_Description()
	{
		return Tutorial_Description;
	}
	
	
	public String GetTutorial_Header()
	{
		return Tutorial_Header;
	}
	
	public int GetTutorial_ID()
	{
		return Tutorial_ID;
	}
	
	
}
