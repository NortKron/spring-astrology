package com.astrology.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WhatIsController
{
	
	public WhatIsController()
	{
		
	}
	
	@GetMapping("/whatisastrology")
	public String index(Model model)
	{
		return "whatisastrology";
	}
}
