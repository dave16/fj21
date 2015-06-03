package br.com.dc.bd.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.dc.models.Contato;
import br.com.dc.models.Usuario;

public class ContatoDAO {

	private Connection conexao;

	public ContatoDAO() {
		this.conexao = new ConnectionFactory().getConnection();
		System.out.println("Conectado");
	}

	Usuario usuario = new Usuario();

	public void adiciona(Contato contato) {

		String sql = "insert into contato (nome,email,endereco,dataNascimento,dataCadastro,usuario_id) values (?,?,?,?,?,LAST_INSERT_ID())";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));
			stmt.setDate(5, new Date(contato.getDataCadastro()
					.getTimeInMillis()));

			// executa
			stmt.execute();
			stmt.close();

			System.out.println("Adicionado com sucesso");
			System.out.println();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario adicionaUsuario(Usuario usuario) {
		this.usuario = usuario;
		String sql = "insert into usuario(login,senha) values(?,?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println(usuario.getLogin());
		return usuario;
	}

	public List<Contato> getLista() {

		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.conexao
					.prepareStatement("select * from contato");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				// montando a data atrav�s do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				Calendar dataCadastro = Calendar.getInstance();
				dataCadastro.setTime(rs.getDate("dataCadastro"));
				contato.setDataCadastro(dataCadastro);

				// adicionando o objeto � lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Contato buscaContato(Contato contatoId) {

		String sql = "select * from contato where id =?";
		Contato contato = new Contato();
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setLong(1, contatoId.getId());
			// stmt.setInt(1, contatoId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return contato;
	}

	public void altera(Contato contato) {

		String sql = "update contato set nome=?, email=?, endereco=?, dataNascimento=? where id=?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = conexao
					.prepareStatement("delete from contato where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean verificaLogin(Usuario usuario) throws SQLException {
		String sql = "select * from usuario where login=? and senha=?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();
			if (!rs.next()) {
				System.out.println("N�o Encontrado");
				stmt.close();
				return false;
			} else {
				System.out.println("Encontrado");
				return true;
			}
	}
	
}
