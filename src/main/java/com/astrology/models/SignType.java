package com.astrology.models;

public class SignType
{
	private int SignId;
	private String SignName;
	private int HoroscopeId;

	public SignType()
	{

	}

	public SignType(int SignId, String SignName, int HoroscopeId)
	{
		this.SignId = SignId;
		this.SignName = SignName;
		this.HoroscopeId = HoroscopeId;
	}

	public int getSignId()
	{
		return SignId;
	}

	public void setSignId(int SignId)
	{
		this.SignId = SignId;
	}

	public String getSignName()
	{
		return SignName;
	}

	public void setSignName(String SignName)
	{
		this.SignName = SignName;
	}
	
	public int getHoroscopeId()
	{
		return HoroscopeId;
	}

	public void setHoroscopeId(int HoroscopeId)
	{
		this.HoroscopeId = HoroscopeId;
	}
}
