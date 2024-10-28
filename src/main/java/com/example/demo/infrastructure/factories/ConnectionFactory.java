package com.example.demo.infrastructure.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection() {
		
		try {
			
			var host = "jdbc:postgresql://localhost:5432/bd_contatos";
			var user = "postgres";
			var pass = "password";
			
			return DriverManager.getConnection(host, user, pass);
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
