package br.com.senac.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.domain.EmpresaCliente;

public interface EmpresaClienteRepository extends JpaRepository<EmpresaCliente, Integer> {
	
	Optional<EmpresaCliente> findById(Integer EmpresaClienteId);
	
	List<EmpresaCliente> findByNome(String nome);
	
}
