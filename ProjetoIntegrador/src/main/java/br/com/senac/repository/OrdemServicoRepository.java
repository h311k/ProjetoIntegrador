package br.com.senac.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.domain.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Integer> {
	
	Optional<OrdemServico> findById(Integer ordemServicoId);
	
	List<OrdemServico> findByDataInicio(Date dataInicio);
	
	List<OrdemServico> findByDataFim(Date dataFim);
	
	List<OrdemServico> findByStatus(String status);

}
