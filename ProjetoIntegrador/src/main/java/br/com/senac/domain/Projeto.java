package br.com.senac.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "projeto")
public class Projeto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "projeto_id")
	private Integer projetoId;
	
	@Column(name = "projeto_nome")
	private String nome;
	
	@Column(name = "projeto_descricao")
	private String descricao;
	
	@Column(name = "projeto_local")
	private String local;
	
	@Column(name = "projeto_data_inicio")
	private Date dataInicio;
	
	@Column(name = "projeto_data_fim")
	private Date dataFim;
	
	@Column(name = "projeto_status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "projeto_tipo_id")
	private ProjetoTipo tipo;
	
	@ManyToOne
	private EmpresaCliente empresaCliente;

	public Integer getProjetoId() {
		return projetoId;
	}

	public void setProjetoId(Integer projetoId) {
		this.projetoId = projetoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ProjetoTipo getTipo() {
		return tipo;
	}

	public void setTipo(ProjetoTipo tipo) {
		this.tipo = tipo;
	}

	public EmpresaCliente getEmpresaCliente() {
		return empresaCliente;
	}

	public void setEmpresaCliente(EmpresaCliente empresaCliente) {
		this.empresaCliente = empresaCliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
