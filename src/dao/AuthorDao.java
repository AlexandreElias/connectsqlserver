package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import factory.ConnectionFactory;
import model.Author;



public class AuthorDao {
	
	//create
	public void create(Author autor) {
		String sql = "INSERT INTO author (id, name) VALUES (?, ?)";
		//try with resources
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setInt(1 , autor.getId());
				ps.setString(2, autor.getName());
				ps.execute();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//read
	public Author read(int id) {
		String sql = "SELECT * FROM author WHERE id = ?";
		Author autor = new Author();
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					autor.setId(rs.getInt("id"));
					autor.setName(rs.getString("nome"));
				}
				return autor;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	//update
	public void update(Author author) {
		String sql = "UPDATE author SET name = ? WHERE id = ?";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setString(1, author.getName());
			ps.setInt(2, author.getId());
			ps.execute();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	//delete
	public void delete(Author autor) {
		String sql = "DELETE FROM author WHERE id = ?";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setInt(1, autor.getId());
			ps.execute();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	//list	
	public List<Author> list() {
		String sql = "SELECT * FROM author";
		List<Author> authors = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection();

				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Author autor = new Author();
				autor.setId(id);
				autor.setName(name);
				authors.add(autor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < authors.size(); i++) {
			System.out.println(authors.get(i));
		}
		
		return authors;
	}
	
	//search
	public List <Author> search (String chave){
		String sql = "SELECT * FROM equipamento WHERE UPPER(name) LIKE ?";
		List <Author> authors = new LinkedList <> ();
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setString(1, "%" + chave + "%");
			try (ResultSet rs = ps.executeQuery()){
				while (rs.next()){
					authors.add(new Author(rs.getInt("id"), rs.getString("name")));
				}
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return authors;
	}
	
	
	
	
	
	

}
