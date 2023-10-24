package com.astrology.config;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@ComponentScan("com.astrology")
public class AstrologyApplication
{
	//private static Logger LOG = LoggerFactory.getLogger(AstrologyApplication.class);

	public static void main(String[] args)
	{
		System.out.println("----------> Start!! <----------");
		SpringApplication.run(AstrologyApplication.class, args);
		
		//ApplicationContext ctx = SpringApplication.run(AstrologyApplication.class, args);
		//DispatcherServlet dispatcherServlet = (DispatcherServlet) ctx.getBean("dispatcherServlet");
		//dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
	}
}
