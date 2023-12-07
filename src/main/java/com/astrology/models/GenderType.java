package com.astrology.models;

public class GenderType
{
	private int GenderId;
	private String GenderName;
	
	public GenderType()
	{
		
	}

	public GenderType(int GenderId, String GenderName)
	{
		this.GenderId = GenderId;
		this.GenderName = GenderName;
	}
	
	public int getGenderId()
	{
		return GenderId;
	}

	public void setGenderId(int GenderId)
	{
		this.GenderId = GenderId;
	}

	public String getGenderName()
	{
		return GenderName;
	}

	public void setGenderName(String GenderName)
	{
		this.GenderName = GenderName;
	}	
}
