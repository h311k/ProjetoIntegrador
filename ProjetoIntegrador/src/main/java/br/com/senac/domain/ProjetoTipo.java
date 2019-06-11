package br.com.senac.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projeto_tipo")
public class ProjetoTipo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "projeto_tipo_id")
	private Integer projetoTipoId;
	
	@Column(name = "projeto_tipo_descricao")
	private String descricao;
	
	@Column(name = "projeto_tipo_status")
	private String status;

	public Integer getProjetoTipoId() {
		return projetoTipoId;
	}

	public void setProjetoTipoId(Integer projetoTipoId) {
		this.projetoTipoId = projetoTipoId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
