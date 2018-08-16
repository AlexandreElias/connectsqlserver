package main;


import model.Author;
import service.AuthorService;

public class Dboperations {

	public static void main(String[] args) {
		AuthorService authorService = new AuthorService();
		
		Author author1 = new Author();
		Author author2 = new Author();
		Author author3 = new Author();
		
		author1.setName("Will");
		author1.setId(1);
		
		author2.setName("William");
		author2.setId(1);
		
		author3.setName("Alexandre");
		author3.setId(2);
		
		
		System.out.println("Inserindo Autor1 id:1");
			authorService.create(author1);
				
		System.out.println("Listando Autores.");
			authorService.list();
		
		System.out.println("Atualizando Autor1 com Autor2 id:1.");
			authorService.update(author2);
		
		System.out.println("Listando Autores.");
			authorService.list();
		
		System.out.println("Inserindo Autor3 id:2");
			authorService.create(author3);
		
		System.out.println("Listando autores.");
			authorService.list();
		
		System.out.println("Deletando autor2 id:1");
			authorService.delete(author2);
		
		System.out.println("Listando autores");
			authorService.list();
		
		System.out.println("Deletando autor3 id:2");
			authorService.delete(author3);
		
		System.out.println("Listando autores.");
			authorService.list();
	}

}
