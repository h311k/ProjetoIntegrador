package br.com.senac.inicializacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.dominio.Colaborador;
import br.com.senac.dominio.Material;
import br.com.senac.dominio.OrdemServico;
import br.com.senac.repositorio.ColaboradorRepositorio;
import br.com.senac.repositorio.MaterialRepositorio;
import br.com.senac.repositorio.OrdemServicoRepositorio;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private ColaboradorRepositorio colaboradorRepositorio;
	
	@Autowired
	private MaterialRepositorio materialRepositorio;
	
	@Autowired
	private OrdemServicoRepositorio ordemServicoRepositorio;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Colaborador colaborador = new Colaborador();
		
		colaborador.setNome("Pessoa");
		colaborador.setSobrenome("Sobrenome");
		colaborador.setSenha("19650917");
		colaborador.setStatus("1");
		colaborador.setTelefone("2122212121");
		
		colaboradorRepositorio.save(colaborador);
		
		colaborador = colaboradorRepositorio.findByTelefone("2122212121");
		colaborador.setSobrenome("Novo Sobrenome");
		colaboradorRepositorio.save(colaborador);
		
		Material material = new Material();
		
		material.setNome("Material de teste");
		material.setDescricao("Descrição do material");
		material.setUnidadeMedida("undiade");
		
		materialRepositorio.save(material);
		
		OrdemServico ordemServico = new OrdemServico();
		
		ordemServico.setColaborador(colaborador);
		ordemServico.setDataInicio(new Date());
		ordemServico.setLocal("Local fictício");
		ordemServico.setDescricao("Obra de reparo");
		ordemServico.setStatus("1");
		List<Material> materiais = new ArrayList<>();
		materiais.add(material);
		ordemServico.setMateriais(materiais);
		
		ordemServicoRepositorio.save(ordemServico);
		
	}
	
}
