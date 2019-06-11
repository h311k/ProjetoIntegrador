package br.com.senac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.senac.domain.Colaborador;


public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {
	
	Colaborador findByTelefone(String telefone);
	
	List<Colaborador> findByNome(String nome);
	
	Colaborador findByUsuario(String usuario);
	
	@Query("select c from Colaborador c where c.nome=?1 and c.sobrenome=?2")
	List<Colaborador> findByNomeSobrenome(String nome, String sobrenome);

}
