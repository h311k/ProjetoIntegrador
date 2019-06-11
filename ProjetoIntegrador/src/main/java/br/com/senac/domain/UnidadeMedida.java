package br.com.senac.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unidade_medida")
public class UnidadeMedida implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "unidade_medida_id")
	private Integer unidadeMedidaId;
	
	@Column(name = "ordem_servico_descricao")
	private String descricao;
	
	@Column(name = "ordem_servico_local")
	private String local;
	
	

}
