package br.com.senac.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresa_cliente")
public class EmpresaCliente implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "empresa_cliente_id")
	private Integer empresaClienteId;
	
	@Column(name = "empresa_cliente_nome")
	private String EmpresaClienteNome;

	public Integer getEmpresaClienteId() {
		return empresaClienteId;
	}

	public void setEmpresaClienteId(Integer empresaClienteId) {
		this.empresaClienteId = empresaClienteId;
	}

	public String getEmpresaClienteNome() {
		return EmpresaClienteNome;
	}

	public void setEmpresaClienteNome(String empresaClienteNome) {
		EmpresaClienteNome = empresaClienteNome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
