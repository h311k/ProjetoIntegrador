package br.com.senac.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MaterialOrdemServicoId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="ordem_servico_id")
	private Integer ordemServicoId;
	
	@Column(name="projeto_id")
	private Integer projetoId;
	
	@Column(name="material_id")
	private Integer MaterialId;

	public MaterialOrdemServicoId(Integer ordemServicoId, Integer projetoId, Integer materialId) {
		super();
		this.ordemServicoId = ordemServicoId;
		this.projetoId = projetoId;
		MaterialId = materialId;
	}
	
	public MaterialOrdemServicoId() {
		
	}

	public Integer getOrdemServicoId() {
		return ordemServicoId;
	}

	public void setOrdemServicoId(Integer ordemServicoId) {
		this.ordemServicoId = ordemServicoId;
	}

	public Integer getProjetoId() {
		return projetoId;
	}

	public void setProjetoId(Integer projetoId) {
		this.projetoId = projetoId;
	}

	public Integer getMaterialId() {
		return MaterialId;
	}

	public void setMaterialId(Integer materialId) {
		MaterialId = materialId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o ) return true;
		if(!(o instanceof MaterialOrdemServicoId)) return false;
		MaterialOrdemServicoId that = (MaterialOrdemServicoId) o;
		return Objects.equals(getProjetoId(), that.getProjetoId()) && Objects.equals(getOrdemServicoId(), that.getOrdemServicoId()) && Objects.equals(getMaterialId(), that.getMaterialId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getProjetoId(), getOrdemServicoId(), getMaterialId());
	}
}
