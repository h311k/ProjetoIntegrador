package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.ProjetoTipo;
import br.com.senac.repository.ProjetoTipoRepository;
import br.com.senac.service.exception.ObjectNotFoundException;

@Service
public class ProjetoTipoService {
	
	@Autowired
	private ProjetoTipoRepository projetoTipoRepository;
	
	public ProjetoTipo busca(Integer projetoTipoId) {
		Optional<ProjetoTipo> projetoTipo = projetoTipoRepository.findById(projetoTipoId);
		return projetoTipo.orElseThrow(() -> new ObjectNotFoundException("ProjetoTipo não encontrado! Id: "+projetoTipoId+", Tipo: "+ProjetoTipo.class.getName()));
	}
	
	public ProjetoTipo insere(ProjetoTipo projetoTipo) {
		projetoTipo.setProjetoTipoId(null);
		return projetoTipoRepository.save(projetoTipo);
	}

	public ProjetoTipo altera(ProjetoTipo projetoTipo) {
		Optional<ProjetoTipo> projetoTipoEncontrado = projetoTipoRepository.findById(projetoTipo.getProjetoTipoId());
		projetoTipoEncontrado.get().setDescricao(projetoTipo.getDescricao());
		return projetoTipoRepository.save(projetoTipoEncontrado.get());
	}

	public void excluir(Integer id) {
		projetoTipoRepository.deleteById(id);
	}

	public List<ProjetoTipo> listaTodos() {
		return projetoTipoRepository.findAll();
	}

}
