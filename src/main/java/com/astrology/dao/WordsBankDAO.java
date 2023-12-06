package com.astrology.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.astrology.models.WordsBank;

@Component
public class WordsBankDAO
{
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public WordsBankDAO(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public WordsBank index(int SignId)
	{
		return jdbcTemplate.query("SELECT * FROM \"WordsBank\" where \"SignId\"=?", new BeanPropertyRowMapper<>(WordsBank.class), SignId)
				.stream().findAny().orElse(null);
	}
}
