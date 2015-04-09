package br.com.dc.bd.jdbc;

public class TestaConexao {

	public static void main(String[] args) throws ClassNotFoundException {
		
		ConnectionFactory conexao = new ConnectionFactory();
		conexao.getConnection();
		System.out.println("Conectado");
		
	}
}
