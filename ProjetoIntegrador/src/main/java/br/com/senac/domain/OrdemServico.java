package br.com.senac.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordem_servico")
public class OrdemServico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ordem_servico_id")
	private Integer ordemServicoId;
	
	@Column(name = "ordem_servico_data_inicio")
	private Date dataInicio;
	
	@Column(name = "ordem_servico_data_fim")
	private Date dataFim;
	
	@Column(name = "ordem_servico_contratado")
	private String contratado;
	
	@Column(name = "ordem_servico_status")
	private String status;
	
	@OneToOne
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;
	
	@OneToOne
	@JoinColumn(name = "colaborador_id")
	private Colaborador colaborador;

	public Integer getOrdemServicoId() {
		return ordemServicoId;
	}

	public void setOrdemServicoId(Integer ordemServicoId) {
		this.ordemServicoId = ordemServicoId;
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

	public String getContratado() {
		return contratado;
	}

	public void setContratado(String contratado) {
		this.contratado = contratado;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
