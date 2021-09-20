package palvelinohjelmointi.kirjakauppa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import palvelinohjelmointi.kirjakauppa.domain.BookRepository;


@Controller
public class BookController {
	
	// indexsivu Getillä
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String bookTitle(@RequestParam(value="title") String title, Model model) {
		model.addAttribute("title", title);
		return "kirjakauppa";
}
	@Autowired
	private BookRepository repository;
	
	//listview luonti
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String Booklist(Model model) {
		//key attribuutille "listan nimi", toka parametri = value, kirjat jotka saadaan tietokannasta findAll avulla.
		model.addAttribute("books", repository.findAll());
		//return stringi, templaten nimi tähän, joka luodaan seuraavaksi
		return "booklist";
	}
	
	
	
}
