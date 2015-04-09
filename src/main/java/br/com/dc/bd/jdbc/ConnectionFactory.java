package br.com.dc.bd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

		
	public Connection getConnection() {
		
		String urlBanco= "jdbc:mysql://localhost/fj21";
		String usuario = "root";
		String senha = "";
		
		System.out.println("Conectando ao Banco");
		try{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 
			return DriverManager.getConnection(urlBanco	, usuario, "");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
