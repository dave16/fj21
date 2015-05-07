package br.com.dc.models;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name = "CONTATO_SEQUENCE" , sequenceName = "CONTATO_SEQUENCE" , allocationSize = 1 , initialValue = 0)
public class Contato {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY , generator = "CONTATO_SEQUENCE")
	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;
	private Calendar dataCadastro;
	@OneToOne(cascade=CascadeType. ALL , optional = false , fetch = FetchType.EAGER ,orphanRemoval=true)
	@PrimaryKeyJoinColumn
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
