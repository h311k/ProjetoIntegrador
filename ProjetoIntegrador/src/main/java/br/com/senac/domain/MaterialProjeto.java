package br.com.senac.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "material_projeto")
public class MaterialProjeto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "material_id")
	private Integer materialId;
	
	@ManyToOne
	@JoinColumn(name = "material_material_id")
	private MaterialArmazenamento material;
	
	@ManyToOne
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;
	
	@Column(name = "material_projeto_quantidade")
	private String quantidade;

}
