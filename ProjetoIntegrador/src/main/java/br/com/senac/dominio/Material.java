package br.com.senac.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "material")
public class Material implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "material_id")
	private Integer materialId;
	
	@Column(name = "material_nome", length = 45)
	private String nome;
	
	@Column(name = "material_descricao", length = 240)
	private String descricao;
	
	@Column(name = "material_unidade_medida", length = 40)
	private String unidadeMedida;
	
	@ManyToMany
	@JoinTable(name="ordem_servico_material", joinColumns = @JoinColumn(name="material_id"), inverseJoinColumns = @JoinColumn(name="ordem_servico_id"))
	List<OrdemServico> ordensServico = new ArrayList<>();

	public Integer getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
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

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
