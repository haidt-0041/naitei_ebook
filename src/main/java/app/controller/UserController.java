package app.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.model.User;
import app.service.UserService;

@Controller
public class UserController extends BaseController {
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	

	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable("id") int id) {
		logger.info("detail user");
		ModelAndView model = new ModelAndView("/front/user/show");
		User user = userService.findById(id);
		if (user == null) {
			model.addObject("error", messageSource.getMessage("user.notFound", null, Locale.US));

		} else {
			model.addObject("user", user);

		}
		return model;
	}

	@RequestMapping(value = "/admin/users")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("/admin/user/index");
		model.addObject("users", userService.loadUsers());
		return model;
	}

	@RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
	public String newUser(Model model) {
		User user = new User();

		// set default value
		user.setSex(0);

		model.addAttribute("userForm", user);
		model.addAttribute("status", "add");

		return "/admin/user/user-form";

	}

	@RequestMapping(value = "/admin/users", method = RequestMethod.POST)
	public String saveOrUpdate(@Valid @ModelAttribute("userForm") User user, BindingResult bindingResult, Model model,
			final RedirectAttributes redirectAttributes) {
		logger.info("add user");
//		userService.saveOrUpdate(user);
		model.addAttribute("userForm", user);
		model.addAttribute("status", "add");
		if (bindingResult.hasErrors()) {
			return "/admin/user/user-form";
		}
		userService.saveOrUpdate(user);
		String message = messageSource.getMessage("saveOrUpdateSuccess", null, Locale.US);
		redirectAttributes.addFlashAttribute("success", message);
		return "redirect:/admin/users";

	}

	@RequestMapping(value = "admin/users/{id}/edit", method = RequestMethod.GET)
	public String editUser(@PathVariable("id") int id, Model model) {

		User user = userService.findById(id);
		model.addAttribute("userForm", user);
		model.addAttribute("status", "edit");

		return "/admin/user/user-form";

	}

	@RequestMapping(value = "/admin/users/{id}/delete", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Integer id, final RedirectAttributes redirectAttributes) {
		logger.info("delete user");
		if (userService.deleteUser(id)) {
			redirectAttributes.addFlashAttribute("css", "success");
			String message = messageSource.getMessage("user.deleted", null, Locale.US);
			redirectAttributes.addFlashAttribute("success", message);

		} else {
			redirectAttributes.addFlashAttribute("css", "error");
			String message = messageSource.getMessage("user.deletefail", null, Locale.US);
			redirectAttributes.addFlashAttribute("error", message);
		}

		return "redirect:/admin/users";

	}

}
