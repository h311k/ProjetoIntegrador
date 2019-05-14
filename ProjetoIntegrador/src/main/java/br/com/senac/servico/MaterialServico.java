package br.com.senac.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Material;
import br.com.senac.repositorio.MaterialRepositorio;
import br.com.senac.servico.exception.ObjectNotFoundException;

@Service
public class MaterialServico {

	@Autowired
	MaterialRepositorio materialRepositorio;
	
	public Material buscar(Integer materialId) {
		Optional<Material> material = materialRepositorio.findById(materialId);
		return material.orElseThrow(() -> new ObjectNotFoundException("Material não encontrado! Id: "+materialId+", Tipo: "+Material.class.getName()));
	}
	
	public Material insere(Material material) {
		material.setMaterialId(null);
		return materialRepositorio.save(material);
	}
	
	public Material edita(Material material) {
		Optional<Material> retorno = materialRepositorio.findById(material.getMaterialId());
		retorno.get().setNome(material.getNome());
		retorno.get().setDescricao(material.getDescricao());
		retorno.get().setUnidadeMedida(material.getUnidadeMedida());
		return materialRepositorio.save(material);
	}
	
	public void exclui(Integer materialId) {
		materialRepositorio.deleteById(materialId);
	}
	
	public List<Material> listaTodos() {
		return materialRepositorio.findAll();
	}
}
