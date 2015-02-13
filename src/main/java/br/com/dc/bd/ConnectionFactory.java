package br.com.dc.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

		
	public Connection getConnection() {
		System.out.println("Conectando ao Banco");
		try{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
