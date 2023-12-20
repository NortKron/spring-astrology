package com.astrology.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ErrorsController implements ErrorController
{

	@ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFoundError()
	{
        System.out.println("Error 404!");
        return "error_page";
    }
}