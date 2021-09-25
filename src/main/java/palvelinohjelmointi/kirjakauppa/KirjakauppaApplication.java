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
	 Book Harry1 = new Book("Härri Pötter ja Äzkäbän", "J.K. Rowling" , 2001, "12314", 20);
	 Book Harry2 = new Book("Härri Pötter ja Tunkkainen Pikari", "J.K. Rowling" , 2004, "12322", 23);
	 Book Harry3 = new Book("Härri Pötter ja Kuoleman Ahmatit", "J.K. Rowling" , 2006, "123432", 30);
	 
	 Category Fiction = new Category("Fiction");
	 Category Fantasy = new Category("Fantasy");
	 Category Horror = new Category("Horror");
	  
	 
	 repository.save(Harry1);
	 repository.save(Harry2);
	 repository.save(Harry3);
	 
	 catrep.save(Fiction);
	 catrep.save(Fantasy);
	 catrep.save(Horror);
		};
	}

}
