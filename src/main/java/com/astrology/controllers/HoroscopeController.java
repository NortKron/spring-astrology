package com.astrology.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lex PopKorn73
 */
@Controller
@RequestMapping("/horoscope")
public class HoroscopeController 
{
	@GetMapping()
	public String index(Model model) 
	{
		//model.addAttribute("people", personDAO.index());
		return "form";
	}

}
