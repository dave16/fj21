package br.com.dc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="USUARIO_SEQUENCIA" , sequenceName = "USUARIO_SEQUENCIA" ,  allocationSize=1, initialValue=0)
public class Usuario {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "USUARIO_SEQUENCIA" )
	private Long id;
	private String login;
	private String senha;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
