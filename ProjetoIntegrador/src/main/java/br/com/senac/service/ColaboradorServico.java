package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Colaborador;
import br.com.senac.repository.ColaboradorRepository;
import br.com.senac.service.exception.ObjectNotFoundException;
import br.com.senac.util.Encriptador;

@Service
public class ColaboradorServico {

	@Autowired
	private ColaboradorRepository colaboradorRepositorio;
	
	private Encriptador encriptador = new Encriptador();
	
	public Colaborador busca(Integer colaboradorId) {
		Optional<Colaborador> colaborador = colaboradorRepositorio.findById(colaboradorId);
		return colaborador.orElseThrow(() -> new ObjectNotFoundException("Colaborador não encontrado! Id: "+colaboradorId+", Tipo: "+Colaborador.class.getName()));
	}
	
	public Colaborador buscaPorTelefone(String telefone) {
		Colaborador colaborador = colaboradorRepositorio.findByTelefone(telefone);
		return colaborador;	
	}
	
	public List<Colaborador> buscaPorNomeSobrenome(String nome, String sobrenome) {
		List<Colaborador> colaboradores;
		if(sobrenome!=null) {
			colaboradores = colaboradorRepositorio.findByNome(nome);
		} else {
			colaboradores = colaboradorRepositorio.findByNomeSobrenome(nome, sobrenome);
		}
		return colaboradores;
	}
	
	public Colaborador insere(Colaborador colaborador) {
		colaborador.setColaboradorId(null);
		colaborador.setSenha(encriptador.encriptaSenha(colaborador.getSenha()));
		colaborador.setStatus("A");
		return colaboradorRepositorio.save(colaborador);
	}
	
	public Colaborador altera(Colaborador colaborador) {
		Colaborador colaboradorEncontrado = colaboradorRepositorio.findByTelefone(colaborador.getTelefone());
		colaboradorEncontrado.setNome(colaborador.getNome());
		colaboradorEncontrado.setSobrenome(colaborador.getSobrenome());
		colaboradorEncontrado.setStatus(colaborador.getStatus());
		colaboradorEncontrado.setTelefone(colaborador.getTelefone());
		if(colaborador.getSenha()!=null) {
			colaboradorEncontrado.setSenha(encriptador.encriptaSenha(colaborador.getSenha()));
		}
		return colaboradorRepositorio.save(colaboradorEncontrado);
	}
	
	public void excluir(Integer id) {
		colaboradorRepositorio.deleteById(id);
	}
	
	public List<Colaborador> listaTodos() {
		return colaboradorRepositorio.findAll();
	}
	
	
}
