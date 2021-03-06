package palvelinohjelmointi.kirjakauppa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//entityn lisäys
@Entity
public class Category {
	
	
	//id luonti
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long categoryid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	@JsonIgnoreProperties("category")
	private List<Book> books;
	
	//constructors
	public Category() {}
	
	public Category(String name) {
		super();
		this.name = name;
	}
	
	public long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(long Categoryid) {
		this.categoryid = Categoryid;
	}
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public List <Book> getBooks (){
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}


	
	@Override
	public String toString() {
		return "Category Name: "+ name ;
	}
	
	

}
