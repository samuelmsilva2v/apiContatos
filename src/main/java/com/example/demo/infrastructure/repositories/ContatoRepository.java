package com.example.demo.infrastructure.repositories;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.demo.domain.models.entities.Contato;
import com.example.demo.infrastructure.factories.ConnectionFactory;

public class ContatoRepository {

	public void insert(Contato contato) throws SQLException {

		var connectionFactory = new ConnectionFactory();
		var connection = connectionFactory.getConnection();

		var statement = connection.prepareStatement(
				"INSERT INTO contato (id, nome, email, telefone, categoria_id ) VALUES (?, ?, ?, ?, ?)");
		statement.setString(1, contato.getId().toString());
		statement.setString(2, contato.getNome());
		statement.setString(3, contato.getEmail());
		statement.setString(4, contato.getTelefone());
		statement.setInt(5, contato.getCategoria().getId());
		statement.execute();

		connection.close();
	}

	public void update(Contato contato) throws SQLException {

		var connectionFactory = new ConnectionFactory();
		var connection = connectionFactory.getConnection();

		var statement = connection
				.prepareStatement("UPDATE contato SET nome=?, email=?, telefone=?, categoria_id=? WHERE id=?");
		statement.setString(1, contato.getNome());
		statement.setString(2, contato.getEmail());
		statement.setString(3, contato.getTelefone());
		statement.setInt(4, contato.getCategoria().getId());
		statement.setString(5, contato.getId().toString());
		statement.execute();

		connection.close();
	}

	public void delete(Integer id) throws SQLException {

		var connectionFactory = new ConnectionFactory();
		var connection = connectionFactory.getConnection();

		var statement = connection.prepareStatement("DELETE FROM contato WHERE id=?");
		statement.setString(1, id.toString());
		statement.execute();

		connection.close();
	}

	public Contato findById(Integer id) throws SQLException {
		
		var connectionFactory = new ConnectionFactory();
		var connection = connectionFactory.getConnection();
		
		var statement = connection.prepareStatement("SELECT * FROM contato WHERE id=?");
		statement.setString(1, id.toString());
		
		var resultSet = statement.executeQuery();
		
		Contato contato = null;
		
		if(resultSet.next()) {
			
			contato = new Contato();
			
			contato.setId(UUID.fromString(resultSet.getString("id")));
			contato.setNome(resultSet.getString("nome"));
			contato.setEmail(resultSet.getString("email"));
			contato.setTelefone(resultSet.getString("telefone"));
		}
		
		connection.close();
		
		return contato;
	}

	public List<Contato> findAll() throws SQLException {
		
		var connectionFactory = new ConnectionFactory();
		var connection = connectionFactory.getConnection();
		
		var statement = connection.prepareStatement("SELECT * FROM contato");
		var resultSet = statement.executeQuery();
		
		var contatos = new ArrayList<Contato>();
		
		while(resultSet.next()) {
			
			var contato = new Contato();
			
			contato.setId(UUID.fromString(resultSet.getString("id")));
			contato.setNome(resultSet.getString("nome"));
			contato.setEmail(resultSet.getString("email"));
			contato.setTelefone(resultSet.getString("telefone"));
			
			contatos.add(contato);	
		}
		
		connection.close();
		
		return contatos;
	}
}
