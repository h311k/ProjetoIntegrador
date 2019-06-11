package br.com.senac.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.domain.MaterialArmazenamento;

public interface MaterialArmazenamentoRepository extends JpaRepository<MaterialArmazenamento, Integer> {
	
	Optional<MaterialArmazenamento> findById(Integer materialArmazenamentoId);
	
	List<MaterialArmazenamento> findByNome(String nome);
	
	List<MaterialArmazenamento> findByTipo(String tipo);
	
	

}
