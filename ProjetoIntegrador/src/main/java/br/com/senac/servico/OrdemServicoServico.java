package br.com.senac.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.OrdemServico;
import br.com.senac.repositorio.OrdemServicoRepositorio;
import br.com.senac.servico.exception.ObjectNotFoundException;

@Service
public class OrdemServicoServico {

	@Autowired
	private OrdemServicoRepositorio ordemServicoRepositorio;
	
	public OrdemServico busca(Integer ordemServicoId) {
		Optional<OrdemServico> ordemServico = ordemServicoRepositorio.findById(ordemServicoId);
		return ordemServico.orElseThrow(() -> new ObjectNotFoundException("Ordem de serviço não encontrada! Id: "+ordemServicoId+", Tipo: "+OrdemServico.class.getName()));
	}
	
//	public List<OrdemServico> buscarPorColaborador(Integer colaboradorId) {
//		List<OrdemServico> ordensServico = ordemServicoRepositorio.findByColaborador(colaboradorId);
//		return ordensServico;
//	}
	
//	public List<OrdemServico> buscarPorIntervaloDataAbertura(Date dataInicial, Date dataFinal) {
//		List<OrdemServico> ordensServico = ordemServicoRepositorio.findByIntervaloDataAbertura(dataInicial, dataFinal);
//		return ordensServico;
//	}
	
//	public List<OrdemServico> buscarPorAbertasHoje() {
//		List<OrdemServico> ordensServico = ordemServicoRepositorio.findByAbertasHoje(new Date());
//		return ordensServico;
//	}
//	
//	public List<OrdemServico> buscarPorFechadasHoje() {
//		List<OrdemServico> ordensServico = ordemServicoRepositorio.findByFechadasHoje(new Date());
//		return ordensServico;
//	}
	
	public List<OrdemServico> listaTodas() {
		List<OrdemServico> ordensServico = ordemServicoRepositorio.findAll();
		return ordensServico;
	}
	
	public OrdemServico insere(OrdemServico ordemServico) {
		ordemServico.setOrdemServicoId(null);
		ordemServico.setStatus("ABERTA");
		return ordemServicoRepositorio.save(ordemServico);
	}
	
	public OrdemServico altera(OrdemServico ordemServico) {
		OrdemServico resultado = this.busca(ordemServico.getOrdemServicoId());
		resultado.setColaborador(ordemServico.getColaorador());
		resultado.setDescricao(ordemServico.getDescricao());
		resultado.setLocal(ordemServico.getLocal());
		resultado.setDataFim(ordemServico.getDataFim());
		resultado.setStatus(ordemServico.getStatus());
		return ordemServicoRepositorio.save(resultado);
	}
	
	public void exclui(Integer ordemServicoId) {
		ordemServicoRepositorio.deleteById(ordemServicoId);
	}
	
}
