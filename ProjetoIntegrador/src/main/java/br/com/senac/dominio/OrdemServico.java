package br.com.senac.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ordem_servico")
public class OrdemServico implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ordem_servico_id")
	private Integer OrdemServicoId;
	
	@Column(name = "ordem_servico_descricao", length = 120)
	private String descricao;
	
	@Column(name = "ordem_servico_local", length = 120)
	private String local;
	
	@Column(name = "ordem_servico_data_inicio")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:MM:ss")
	private Date dataInicio;
	
	@Column(name = "ordem_servico_data_fim")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:MM:ss")
	private Date dataFim;
	
	@Column(name = "ordem_servico_status", length = 1)
	private String status;
	
	@ManyToOne
	@JoinColumn(name="colaborador_id")
	private Colaborador colaborador;
	
	@ManyToMany(mappedBy="ordensServico")
	private List<Material> materiais = new ArrayList<>();

	public Integer getOrdemServicoId() {
		return OrdemServicoId;
	}

	public void setOrdemServicoId(Integer ordemServicoId) {
		OrdemServicoId = ordemServicoId;
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

	public Colaborador getColaorador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public List<Material> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
