package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class BaseController {
	@Autowired
	protected MessageSource messageSource;

}
