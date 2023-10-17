package com.astrology.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{

	/*
	 * @RequestMapping(value="/") public ModelAndView test(HttpServletResponse
	 * response) throws IOException{ return new ModelAndView("home"); }
	 */

	@GetMapping("/")
	public String GetHome()
	{
		return "home";
	}
}
