package com.astrology.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.astrology")
public class AstrologyApplication
{
	//private static Logger LOG = LoggerFactory.getLogger(AstrologyApplication.class);

	public static void main(String[] args) throws Exception
	{
		System.out.println("----------> Start!! <----------");
		SpringApplication.run(AstrologyApplication.class, args);
		
		//ApplicationContext ctx = SpringApplication.run(AstrologyApplication.class, args);
		//DispatcherServlet dispatcherServlet = (DispatcherServlet) ctx.getBean("dispatcherServlet");
		//dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
	}
}
