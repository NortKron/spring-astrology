package com.astrology.dao;

import com.astrology.models.HoroscopeType;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author 
 */
@Component
public class HoroscopeTypeDAO
{
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public HoroscopeTypeDAO(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<HoroscopeType> index()
	{
		return jdbcTemplate.query("SELECT * FROM \"HoroscopeType\"", new BeanPropertyRowMapper<>(HoroscopeType.class)).subList(0, 1);		
	}
	
	public HoroscopeType show(int HoroscopeId)
	{
		return jdbcTemplate.query("SELECT * FROM \"HoroscopeType\" WHERE \"HoroscopeId\"=?", new BeanPropertyRowMapper<>(HoroscopeType.class), HoroscopeId)
				.stream().findAny().orElse(null);
	}

	public void save(HoroscopeType horoscopeType)
	{
		jdbcTemplate.update("INSERT INTO \"HoroscopeType\" VALUES(1, ?, ?, ?)", horoscopeType.getHoroscopeName());
	}

	public void update(int HoroscopeId, HoroscopeType updatedHoroscopeType)
	{
		//jdbcTemplate.update("UPDATE \"HoroscopeType\" SET name=?, age=?, email=? WHERE \"HoroscopeId\"=?", updatedHoroscopeType.getHoroscopeName());
	}

	public void delete(int HoroscopeId)
	{
		//jdbcTemplate.update("DELETE FROM \"HoroscopeType\" WHERE \"HoroscopeId\"=?", HoroscopeId);
	}
}
