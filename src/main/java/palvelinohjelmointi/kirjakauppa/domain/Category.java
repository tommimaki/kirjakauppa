package palvelinohjelmointi.kirjakauppa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//entityn lisäys
@Entity
public class Category {
	
	
	//id luonti
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long id;
	public String name;
	
	
	
	//constructors
	public Category() {}
	
	public Category(String name) {
		super();
		this.name = name;
	}
	
	
	
	//Getters + setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Category Name: "+ name ;
	}
	
	
	
	
	

}
