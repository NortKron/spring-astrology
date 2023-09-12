package com.astrology.models;

import java.util.Date;

public class ZodiacSign
{
	private int id;

	private String name;
	
	private Date birthday;

	public ZodiacSign()
	{

	}

	public ZodiacSign(int id, String name, Date birthday)
	{
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
}
