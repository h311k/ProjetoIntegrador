package br.com.senac.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.domain.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

	Optional<Projeto> findById(Integer projetoId);
	
	List<Projeto> findByNome(String nome);
	
	List<Projeto> findByDataInicio(Date dataInicio);
	
	List<Projeto> findByDataFim(Date dataFim);
	
}
