package br.com.senac.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "material_ordem_servico")
public class MaterialOrdemServico {
	
	@EmbeddedId
	private MaterialOrdemServicoId materialOrdemServicoId;
	
	@Column(name = "quantidade")
	private String quantidade;

	public MaterialOrdemServicoId getMaterialOrdemServicoId() {
		return materialOrdemServicoId;
	}

	public void setMaterialOrdemServicoId(MaterialOrdemServicoId materialOrdemServicoId) {
		this.materialOrdemServicoId = materialOrdemServicoId;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

}
