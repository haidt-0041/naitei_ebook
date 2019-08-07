package app.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.service.UserService;

@Controller
public class HomeController extends BaseController {
	private static final Logger logger = Logger.getLogger(HomeController.class);
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index(Model model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			session.setAttribute("current_user", userService.findByEmail(auth.getName()));
			model.addAttribute("currentUser", auth.getName());
		}

		return "front/home";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) final String error, final Model model) {
		logger.info("login page");
		if (error != null) {
			model.addAttribute("css", "error");
			model.addAttribute("msg", messageSource.getMessage("login.fail", null, Locale.US));
		}
		return "/front/login";
	}

	@RequestMapping("/logout")
	public String logout(final Model model) {
		return "login";
	}

}
