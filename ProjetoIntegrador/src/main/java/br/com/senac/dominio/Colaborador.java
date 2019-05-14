package br.com.senac.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "colaborador")
public class Colaborador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "colaborador_id")
	private Integer colaboradorId;
	
	@Column(name = "colaborador_nome", length = 45)
	private String nome;
	
	@Column(name = "colaborador_sobrenome", length = 45)
	private String sobrenome;
	
	@Column(name = "colaborador_telefone", length = 45)
	private String telefone;
	
	@Column(name = "colaborador_senha", length = 45)
	@JsonIgnore
	private String senha;
	
	@Column(name = "colaborador_status", length = 1)
	private String status;

	public Integer getColaboradorId() {
		return colaboradorId;
	}

	public void setColaboradorId(Integer colaboradorId) {
		this.colaboradorId = colaboradorId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
