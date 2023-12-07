package com.astrology.models;

public class HoroscopeType
{
	private int HoroscopeId;
	private String HoroscopeName;
	
	public HoroscopeType()
	{
		
	}

	public HoroscopeType(int HoroscopeId, String HoroscopeName)
	{
		this.HoroscopeId = HoroscopeId;
		this.HoroscopeName = HoroscopeName;
	}
	
	public int getHoroscopeId()
	{
		return HoroscopeId;
	}

	public void setHoroscopeId(int HoroscopeId)
	{
		this.HoroscopeId = HoroscopeId;
	}

	public String getHoroscopeName()
	{
		return HoroscopeName;
	}

	public void setHoroscopeName(String HoroscopeName)
	{
		this.HoroscopeName = HoroscopeName;
	}	
}
