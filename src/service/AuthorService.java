package service;

import java.util.List;

import model.Author;
import dao.AuthorDao;

public class AuthorService {
	
private AuthorDao authordao = new AuthorDao();
	
	public void create (Author author){
		authordao.create(author);
	}
	
	public void update (Author author){
		authordao.update(author);
	}
	
	public void delete (Author author){
		authordao.delete(author);
	}
	
	public Author read (int id){
		return authordao.read(id);
	}
	
	public List <Author> list (){
		return authordao.list();
	}
	
	public List <Author> search (String chave){
		return authordao.search(chave.toUpperCase());
	}

}
