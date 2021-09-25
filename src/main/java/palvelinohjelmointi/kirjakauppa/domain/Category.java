package palvelinohjelmointi.kirjakauppa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//entityn lisäys
@Entity
public class Category {
	
	
	//id luonti
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Categoryid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	
	//constructors
	public Category() {}
	
	public Category(String name) {
		super();
		this.name = name;
	}
	
	public long getCategoryid() {
		return Categoryid;
	}

	public void setCategoryid(long Categoryid) {
		this.Categoryid = Categoryid;
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
