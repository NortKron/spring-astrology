package com.astrology.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.astrology.models.ForecastTemplates;

@Component
public class ForecastTemplatesDAO
{
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ForecastTemplatesDAO(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<ForecastTemplates> index()
	{
		return jdbcTemplate.query("SELECT * FROM \"ForecastTemplates\"", new BeanPropertyRowMapper<>(ForecastTemplates.class));
	}
}
