package com.astrology.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.astrology.models.ZodiacSign;

public class ZodiacSignDAO
{
	private static int ZODIAC_COUNT;
	
	private static final String URL = "jdbc:postgresql://localhost:5432/astrology_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "4231";
    
    private static Connection connection;
	
	private List<ZodiacSign> zodiacs;

	{
		zodiacs = new ArrayList<>();

		zodiacs.add(new ZodiacSign(++ZODIAC_COUNT, "Aries", new Date()));
		zodiacs.add(new ZodiacSign(++ZODIAC_COUNT, "Taurus", new Date()));
		zodiacs.add(new ZodiacSign(++ZODIAC_COUNT, "Gemini", new Date()));
		zodiacs.add(new ZodiacSign(++ZODIAC_COUNT, "Cancer", new Date()));

		zodiacs.add(new ZodiacSign(++ZODIAC_COUNT, "Leo", new Date()));
		zodiacs.add(new ZodiacSign(++ZODIAC_COUNT, "Virgo", new Date()));
		zodiacs.add(new ZodiacSign(++ZODIAC_COUNT, "Libra", new Date()));
		zodiacs.add(new ZodiacSign(++ZODIAC_COUNT, "Scorpio", new Date()));

		zodiacs.add(new ZodiacSign(++ZODIAC_COUNT, "Sagittarius", new Date()));
		zodiacs.add(new ZodiacSign(++ZODIAC_COUNT, "Capricorn", new Date()));
		zodiacs.add(new ZodiacSign(++ZODIAC_COUNT, "Aquarius", new Date()));
		zodiacs.add(new ZodiacSign(++ZODIAC_COUNT, "Pisces", new Date()));
	}

	public List<ZodiacSign> index()
	{
		return zodiacs;
	}
}
