package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import app.service.UserService;

public class BaseController {
	@Autowired
	protected MessageSource messageSource;
	
	@Autowired
	protected UserService userService;

}
