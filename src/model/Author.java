package model;

public class Author {
	
	int id;
	String name;
	
	
	public Author() {
		
	}
	
	public Author(int id, String name) {
		setName(name);
		setId(id);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Id:"+ this.id +"  Nome:"+ this.name;
		}

}
