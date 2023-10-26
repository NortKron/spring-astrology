package com.astrology.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(path = "/", method = RequestMethod.GET)
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
