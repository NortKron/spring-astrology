package com.astrology.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.astrology.models.GenderType;

@Component
public class GenderTypeDAO
{
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public GenderTypeDAO(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<GenderType> index()
	{
		return jdbcTemplate.query("SELECT * FROM \"GenderType\"", new BeanPropertyRowMapper<>(GenderType.class));
	}

	public GenderType show(int GenderId)
	{
		return jdbcTemplate.query("SELECT * FROM \"GenderType\" WHERE GenderId=?", new BeanPropertyRowMapper<>(GenderType.class), GenderId)
				.stream().findAny().orElse(null);
	}
}
