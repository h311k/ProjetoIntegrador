package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Projeto;
import br.com.senac.repository.ProjetoRepository;
import br.com.senac.service.exception.ObjectNotFoundException;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository repository;
	
	public Projeto busca(Integer projetoId) {
		Optional<Projeto> projeto = repository.findById(projetoId);
		return projeto.orElseThrow(() -> new ObjectNotFoundException("Projeto não encontrado! Id: "+projetoId+", Tipo: "+Projeto.class.getName()));
	}
	
	public Projeto insere(Projeto projeto) {
		projeto.setProjetoId(null);
		return repository.save(projeto);
	}

	public Projeto altera(Projeto projeto) {
		Optional<Projeto> projetoEncontrado = repository.findById(projeto.getProjetoId());
		projetoEncontrado.get().setNome(projeto.getNome());
		projetoEncontrado.get().setDescricao(projeto.getDescricao());
		projetoEncontrado.get().setDataInicio(projeto.getDataInicio());
		projetoEncontrado.get().setDataFim(projeto.getDataFim());
		projetoEncontrado.get().setLocal(projeto.getLocal());
		projetoEncontrado.get().setStatus(projeto.getStatus());
		projetoEncontrado.get().setTipo(projeto.getTipo());
		return repository.save(projetoEncontrado.get());
	}

	public void excluir(Integer id) {
		repository.deleteById(id);
	}

	public List<Projeto> listaTodos() {
		return repository.findAll();
	}
}
