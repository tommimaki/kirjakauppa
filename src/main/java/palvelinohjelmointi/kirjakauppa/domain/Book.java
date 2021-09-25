package palvelinohjelmointi.kirjakauppa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// entity annotaatio
@Entity
public class Book {

	
	
	//autoid
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	// huom muutettu public koska privatella tuli thymeleaf parsing error? pitää varmaan muuttaa vielä
	private long id;
	//muut attribuutit
	private String title;
	private String author;
	private int year;
	private String isbn;
	private double price;
	
	

	// categoryn lisääminen
	@ManyToOne
	@JoinColumn(name = "Categoryid")
	private Category category;
	


	public Book	() {}
	
	public Book(String title, String author, int year, String isbn, double price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		
		
	}
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Book: " + title + author + year + isbn + price ;
}
}