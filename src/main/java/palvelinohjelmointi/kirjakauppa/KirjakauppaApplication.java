package palvelinohjelmointi.kirjakauppa;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import palvelinohjelmointi.kirjakauppa.domain.Book;
import palvelinohjelmointi.kirjakauppa.domain.BookRepository;
import palvelinohjelmointi.kirjakauppa.domain.Category;
import palvelinohjelmointi.kirjakauppa.domain.CategoryRepository;

@SpringBootApplication
public class KirjakauppaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaApplication.class, args);
	}
	
	
	// Bookrepo tähän
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository catrep ) {
	return (args) -> {
		
		 Category Fiction = new Category("Fiction");
		 Category Fantasy = new Category("Fantasy");
		 Category Horror = new Category("Horror");
		  
		 catrep.save(Fiction);
		 catrep.save(Fantasy);
		 catrep.save(Horror);
		 
		 repository.save(new Book("Härri Pötter ja Äzkäbän", "J.K. Rowling" , 2001, "12314", 20, Fiction ));
		 repository.save(new Book("Härri Pötter ja viisasten kivi", "J.K. Rowling" , 2001, "12314", 20, Fantasy ));
		 repository.save(new Book("Härri Pötter ja kuolemien varjelukset", "J.K. Rowling" , 2001, "12314", 20, Horror ));
	
		
	  

		};
	}

}
