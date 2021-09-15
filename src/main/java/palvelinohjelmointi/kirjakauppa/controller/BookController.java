package palvelinohjelmointi.kirjakauppa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String bookTitle(@RequestParam(value="title") String title, Model model) {
		model.addAttribute("title", title);
		return "kirjakauppa";
}
}
