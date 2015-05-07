package br.com.dc.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dc.models.Usuarios;

public class Logar extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse
	         response) throws ServletException, IOException {

	         Connection conexao = null;

	         PreparedStatement stmt = null;

	         ResultSet res = null;

	         try{

	              String login = request.getParameter("login");

	              String senha = request.getParameter("senha");

	              Class.forName("com.mysql.jdbc.Driver");

	              conexao = DriverManager.getConnection("jdbc:mysql://localhost/fj21_jpa", "root", "");

	              stmt = conexao.prepareStatement("SELECT * FROM usuarios WHERE login=?");

	              stmt.setString(1, login);

	              res = stmt.executeQuery();

	              Usuarios usuario = null;

	              if(res.first()){

	                   usuario = new Usuarios();

	                  usuario.setId(res.getInt("id"));

	                   usuario.setNome(res.getString("nome"));

	                   usuario.setLogin(res.getString("login"));

	                   usuario.setSenha(res.getString("senha"));

	              }

	              if(usuario==null||!usuario.getSenha().equals(senha)){

	                   request.getSession().setAttribute("msg", "Login ou senha incorretos!");

	                   response.sendRedirect(request.getContextPath() +  "/login.jsp");

	              }else{

	                   request.getSession().setAttribute("usuario", usuario);

	                   response.sendRedirect(request.getContextPath() +  "/admin/index.jsp");

	              }

	         }catch(Exception e){

	              throw new ServletException(e);

	         }finally{

	              try{

	                   res.close();

	                   stmt.close();

	                   conexao.close();

	              }catch(Exception e){

	                   e.printStackTrace();

	              }

	         }

	     }            

	}



