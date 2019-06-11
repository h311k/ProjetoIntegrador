package br.com.senac.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.domain.ProjetoTipo;

public interface ProjetoTipoRepository extends JpaRepository<ProjetoTipo, Integer> {
	
	Optional<ProjetoTipo> findById(Integer ProjetoTipoId);
	
	ProjetoTipo findByDescricao(String descricao);

}
