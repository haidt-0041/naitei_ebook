package app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

import app.model.Category;
import app.service.CategoryService;

@Controller
public class CategoryController {
	private static final Logger logger = Logger.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "admin/categories")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("admin/category/index");	
		model.addObject("categories", categoryService.list());
		return model;
	}
	
	@RequestMapping(value = "admin/categories/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("categoryForm") Category newCategory, BindingResult errors,  final RedirectAttributes redirectAttributes) {
		logger.info("add categories");
		Category category = categoryService.saveOrUpdate(newCategory);
		if (category != null) {
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", messageSource.getMessage("category.create.success", null, Locale.US));
		} else {
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", messageSource.getMessage("category.create.fail", null, Locale.US));
		}
		return "redirect:/admin/categories";
	}
}
