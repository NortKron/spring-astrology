package com.astrology.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author
 */
@Configuration
@ComponentScan("com.astrology")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer
{
	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public DataSource dataSource()
	{
		/*
		 * TODO: Added to read parameters from file 
		 */
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/astrology_db");
		dataSource.setUsername("postgres");
		dataSource.setPassword("4231");

		return dataSource;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/resources/**").addResourceLocations("/public", "classpath:/static/");
		
		registry.addResourceHandler("/static/css/**").addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("/static/img/**").addResourceLocations("classpath:/static/img/");
		registry.addResourceHandler("/static/javascript/**").addResourceLocations("classpath:/static/javascript/");
				//.setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));
	}
}
