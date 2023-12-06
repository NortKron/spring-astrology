package com.astrology.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.astrology.models.SignType;

@Component
public class SignTypeDAO
{
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SignTypeDAO(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<SignType> index(int HoroscopeId)
	{
		return jdbcTemplate.query("SELECT * FROM \"SignType\" where \"HoroscopeId\"=?", new BeanPropertyRowMapper<>(SignType.class), HoroscopeId);
	}
	
	public SignType show(int SignId)
	{
		return jdbcTemplate.query("SELECT * FROM \"SignType\" WHERE \"SignId\"=?", new BeanPropertyRowMapper<>(SignType.class), SignId)
				.stream().findAny().orElse(null);
	}

	public void save(SignType signType, int HoroscopeId)
	{
		jdbcTemplate.update("INSERT INTO \"SignType\" (\"SignName\", \"HoroscopeId\") VALUES(?, ?)", signType.getSignName(), signType.getHoroscopeId());
	}

	public void update(int id, SignType updatedSignType)
	{
		jdbcTemplate.update("UPDATE \"SignType\" SET \"SignName\"=?, \"HoroscopeId\"=? WHERE \"SignId\"=?", updatedSignType.getSignName());
	}

	public void delete(int SignId)
	{
		jdbcTemplate.update("DELETE FROM \"SignType\" WHERE \"SignId\"=?", SignId);
	}
}
