package br.com.senac.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Colaborador;
import br.com.senac.repositorio.ColaboradorRepositorio;
import br.com.senac.util.Encriptador;

@Service
public class ColaboradorServico {

	@Autowired
	private ColaboradorRepositorio colaboradorRepositorio;
	
	private Encriptador encriptador = new Encriptador();
	
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
