package palvelinohjelmointi.kirjakauppa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import palvelinohjelmointi.kirjakauppa.domain.Category;
import palvelinohjelmointi.kirjakauppa.domain.CategoryRepository;

@Controller
public class CategoryController {

	
	// tuo repo
	@Autowired
	private CategoryRepository catrep;
	
	//listview
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String CategoryList(Model model) {
		model.addAttribute("categories", catrep.findAll());
		return "categorylist";		
	}
	
	// uuden Kategorian lisäys
	@RequestMapping(value="/addcategory")
	public String addBook(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
	// uuden kategorian tallennus
	@RequestMapping(value="/saveCategory", method = RequestMethod.POST)
	public String saveCategory(Category category) {
		catrep.save(category);
		return "redirect:categorylist";
	}
	
	
	
}
