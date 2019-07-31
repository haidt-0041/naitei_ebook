package app.controller.admin;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.controller.BaseController;
import app.model.User;
import app.service.UserService;

@Controller("AdminUserController")
@RequestMapping(value = "/admin/users/")
public class UserController extends BaseController {
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable("id") int id) {
		logger.info("detail user");
		ModelAndView model = new ModelAndView("admin/user/show");
		User user = userService.findById(id);
		if (user == null) {
			model.addObject("error", messageSource.getMessage("user.notFound", null, Locale.US));

		} else {
			model.addObject("user", user);

		}
		return model;
	}

	@RequestMapping
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("/admin/user/index");
		model.addObject("users", userService.loadUsers());
		return model;
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
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

		return "redirect:/admin/users/";

	}

}