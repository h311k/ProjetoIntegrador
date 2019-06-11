package br.com.senac.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.domain.UnidadeMedida;

public interface UnidadeMedidaRepository extends JpaRepository<UnidadeMedida, Integer> {

	Optional<UnidadeMedida> findById(Integer UnidadeMedidaId);

	List<UnidadeMedida> findByDescricao(String descricao);

}
