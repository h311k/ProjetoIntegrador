package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.EmpresaCliente;
import br.com.senac.repository.EmpresaClienteRepository;
import br.com.senac.service.exception.ObjectNotFoundException;

@Service
public class EmpresaClienteService {

	@Autowired
	private EmpresaClienteRepository empresaClienteRepository;

	public EmpresaCliente busca(Integer empresaClienteId) {
		Optional<EmpresaCliente> empresaCliente = empresaClienteRepository.findById(empresaClienteId);
		return empresaCliente.orElseThrow(() -> new ObjectNotFoundException("EmpresaCliente não encontrado! Id: "+empresaClienteId+", Tipo: "+EmpresaCliente.class.getName()));
	}
	
	public EmpresaCliente insere(EmpresaCliente empresaCliente) {
		empresaCliente.setEmpresaClienteId(1);
		return empresaClienteRepository.save(empresaCliente);
	}

	public EmpresaCliente altera(EmpresaCliente empresaCliente) {
		Optional<EmpresaCliente> empresaClienteEncontrado = empresaClienteRepository.findById(empresaCliente.getEmpresaClienteId());
		empresaClienteEncontrado.get().setNome(empresaCliente.getNome());
		return empresaClienteRepository.save(empresaClienteEncontrado.get());
	}

	public void excluir(Integer id) {
		empresaClienteRepository.deleteById(id);
	}

	public List<EmpresaCliente> listaTodos() {
		return empresaClienteRepository.findAll();
	}
}
