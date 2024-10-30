package com.example.demo.infrastructure.repositories;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.models.entities.Categoria;
import com.example.demo.infrastructure.factories.ConnectionFactory;

@Repository
public class CategoriaRepository {

	public void insert(Categoria categoria) throws SQLException {

		var connectionFactory = new ConnectionFactory();
		var connection = connectionFactory.getConnection();

		var statement = connection.prepareStatement("INSERT INTO categoria (nome) VALUES (?)");
		statement.setString(1, categoria.getNome());
		statement.execute();

		connection.close();
	}

	public void update(Integer id, Categoria categoria) throws SQLException {

		var connectionFactory = new ConnectionFactory();
		var connection = connectionFactory.getConnection();

		var statement = connection.prepareStatement("UPDATE categoria SET nome=? WHERE id=?");
		statement.setString(1, categoria.getNome());
		statement.setInt(2, id);
		statement.execute();

		connection.close();
	}

	public void delete(Integer id) throws SQLException {

		var connectionFactory = new ConnectionFactory();
		var connection = connectionFactory.getConnection();

		var statement = connection.prepareStatement("DELETE FROM categoria WHERE id=?");
		statement.setInt(1, id);
		statement.execute();

		connection.close();
	}

	public Categoria findById(Integer id) throws SQLException {

		var connectionFactory = new ConnectionFactory();
		var connection = connectionFactory.getConnection();

		var statement = connection.prepareStatement("SELECT * FROM categoria WHERE id = ?");
		statement.setInt(1, id);
		var resultSet = statement.executeQuery();

		Categoria categoria = null;

		if (resultSet.next()) {

			categoria = new Categoria();

			categoria.setId(resultSet.getInt("id"));
			categoria.setNome(resultSet.getString("nome"));
		}

		connection.close();

		return categoria;
	}

	public List<Categoria> findAll() throws SQLException {

		var connectionFactory = new ConnectionFactory();
		var connection = connectionFactory.getConnection();

		var statement = connection.prepareStatement("SELECT * FROM categoria");
		var resultSet = statement.executeQuery();

		var categorias = new ArrayList<Categoria>();

		while (resultSet.next()) {

			var categoria = new Categoria();

			categoria.setId(resultSet.getInt("id"));
			categoria.setNome(resultSet.getString("nome"));

			categorias.add(categoria);
		}

		connection.close();

		return categorias;
	}

}
