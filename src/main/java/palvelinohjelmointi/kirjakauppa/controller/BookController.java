package palvelinohjelmointi.kirjakauppa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import palvelinohjelmointi.kirjakauppa.domain.Book;
import palvelinohjelmointi.kirjakauppa.domain.BookRepository;
import palvelinohjelmointi.kirjakauppa.domain.CategoryRepository;


@Controller
public class BookController {
	
	// repository objektin tuonti controlleriin(huom @autowired)
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository catrep;
	
	// indexsivu Getillä
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String bookTitle(@RequestParam(value="title") String title, Model model) {
		model.addAttribute("title", title);
		return "kirjakauppa";
	}
	
	//listview luonti
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String Booklist(Model model) {
		//key attribuutille "listan nimi", toka parametri = value, kirjat jotka saadaan tietokannasta findAll avulla.
		model.addAttribute("books", repository.findAll());
		//return stringi, templaten nimi tähän, joka luodaan seuraavaksi
		return "booklist";
	}
	
	//REST getallbooks
	 @RequestMapping(value="/books", method = RequestMethod.GET)
	    public @ResponseBody List<Book> bookListRest() {	
	        return (List<Book>) repository.findAll();
	    }    
	 
	 
	// REST Book by id
	    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long BookId) {	
	    	return repository.findById(BookId);
	    }  
	
	    // RESTful service to save new student
	    @RequestMapping(value="/books", method = RequestMethod.POST)
	    public @ResponseBody Book saveBookRest(@RequestBody Book book) {	
	    	return repository.save(book);
	    }

	
	
	//uuden kirjan lisäys
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catrep.findAll());
		return "addbook";
	}
	
	// uuden kirjan tallennus
	@RequestMapping(value="/save", method = RequestMethod.POST)
	// jos id 0 tai null tulee sql insertn muuten update 
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	
	//delete toiminnallisuus
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id")Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	// edit toiminnallisuus
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id")Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		return "editbook";
	}
	
	
	
}
