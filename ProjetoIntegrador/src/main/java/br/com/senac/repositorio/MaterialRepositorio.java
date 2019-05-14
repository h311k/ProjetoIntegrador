package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.dominio.Material;

public interface MaterialRepositorio extends JpaRepository<Material, Integer> {
	
	

}
