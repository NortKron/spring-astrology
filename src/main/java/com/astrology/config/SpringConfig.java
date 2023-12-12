package com.astrology.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Lex PopKorn
 */
@Configuration
@ComponentScan("com.astrology")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer
{	
	private final Environment env;
	
    public SpringConfig(Environment env) 
	{
        this.env = env;
    }
	
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
		/*
        dataSource.setDriverClassName(env.getRequiredProperty("application.driver_class"));
        dataSource.setUrl(env.getRequiredProperty("application.connection.url"));
        dataSource.setUsername(env.getRequiredProperty("application.connection.username"));
        dataSource.setPassword(env.getRequiredProperty("application.connection.password"));
		*/
		
        dataSource.setDriverClassName(System.getenv("driver_class"));
        dataSource.setUrl(System.getenv("DATABASE_URL"));
        dataSource.setUsername(System.getenv("username"));
        dataSource.setPassword(System.getenv("password"));
		
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
