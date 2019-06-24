package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Colaborador;
import br.com.senac.repository.ColaboradorRepository;
import br.com.senac.service.exception.ObjectNotFoundException;
import br.com.senac.util.Security;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	Security security = new Security();
	
	private Security encriptador = new Security();
	
	public Colaborador busca(Integer colaboradorId) {
		Optional<Colaborador> colaborador = colaboradorRepository.findById(colaboradorId);
		return colaborador.orElseThrow(() -> new ObjectNotFoundException("Colaborador não encontrado! Id: "+colaboradorId+", Tipo: "+Colaborador.class.getName()));
	}
	
	public Colaborador buscaPorTelefone(String telefone) {
		Colaborador colaborador = colaboradorRepository.findByTelefone(telefone);
		return colaborador;	
	}
	
	public Colaborador findUsuarioSenha(Colaborador colaborador) {
		colaborador.setSenha(security.encriptaSenha(colaborador.getSenha()));
		colaborador = colaboradorRepository.findByUsuarioSenha(colaborador.getUsuario(), colaborador.getSenha());
		return colaborador;
	}
	
	public List<Colaborador> buscaPorNomeSobrenome(String nome, String sobrenome) {
		List<Colaborador> colaboradores;
		if(sobrenome!=null) {
			colaboradores = colaboradorRepository.findByNome(nome);
		} else {
			colaboradores = colaboradorRepository.findByNomeSobrenome(nome, sobrenome);
		}
		return colaboradores;
	}
	
	public Colaborador insere(Colaborador colaborador) {
		colaborador.setColaboradorId(null);
		colaborador.setSenha(encriptador.encriptaSenha(colaborador.getSenha()));
		colaborador.setStatus("A");
		return colaboradorRepository.save(colaborador);
	}
	
	public Colaborador altera(Colaborador colaborador) {
		Colaborador colaboradorEncontrado = colaboradorRepository.findByUsuario(colaborador.getUsuario());
		colaboradorEncontrado.setNome(colaborador.getNome());
		colaboradorEncontrado.setSobrenome(colaborador.getSobrenome());
		colaboradorEncontrado.setStatus(colaborador.getStatus());
		colaboradorEncontrado.setTelefone(colaborador.getTelefone());
		if(colaborador.getSenha()!=null) {
			colaboradorEncontrado.setSenha(encriptador.encriptaSenha(colaborador.getSenha()));
		}
		return colaboradorRepository.save(colaboradorEncontrado);
	}
	
	public void excluir(Integer id) {
		colaboradorRepository.deleteById(id);
	}
	
	public List<Colaborador> listaTodos() {
		return colaboradorRepository.findAll();
	}
	
	
}
