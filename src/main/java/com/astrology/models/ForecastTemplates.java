package com.astrology.models;

public class ForecastTemplates
{
	private int id;
	private String Template;
	
	public ForecastTemplates()
	{
		
	}
	
	public ForecastTemplates(int id, String Template)
	{
		this.id = id;
		this.Template = Template; 
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id= id;
	}
	
	public String getTemplate()
	{
		return Template;
	}
	
	public void setTemplate(String Template)
	{
		this.Template = Template;
	}
}
