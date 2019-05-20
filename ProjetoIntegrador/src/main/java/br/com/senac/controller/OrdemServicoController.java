package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.OrdemServico;
import br.com.senac.servico.ColaboradorServico;
import br.com.senac.servico.OrdemServicoServico;
import br.com.senac.servico.exception.ObjectNotFoundException;

@Controller
@RequestMapping("/ordemservico")
public class OrdemServicoController {

	@Autowired
	private OrdemServicoServico ordemServicoServico;
	
	@Autowired
	private ColaboradorServico colaboradorServico;
	
	@GetMapping("/lista")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("ordemServico/administra");
		mv.addObject("ordensServico", ordemServicoServico.listaTodas());
		return mv;
	}
	
	@GetMapping("/adiciona")
	public ModelAndView adiciona() {
		ModelAndView mv = new ModelAndView("ordemServico/adiciona");
		mv.addObject("ordemServico", new OrdemServico());
		mv.addObject("colaboradores", colaboradorServico.listaTodos());
		return mv;
	}
	
	@PostMapping("/insere")
	public ModelAndView salva(OrdemServico ordemServico) {
		ordemServicoServico.insere(ordemServico);
		return lista();
	}
	
	@GetMapping("/exclui/{materialId}")
	public ModelAndView exclui(@PathVariable("materialId") Integer id) {
		ordemServicoServico.exclui(id);
		return lista();
	}
	
	@GetMapping("/altera/{materialId}")
	public ModelAndView altera(@PathVariable("materialId") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("ordemServico/altera");
		mv.addObject("ordemServico", ordemServicoServico.busca(id));
		return mv;
	}
	
	@PostMapping("/altera")
	public ModelAndView altera(OrdemServico ordemServico) throws ObjectNotFoundException {
		ordemServicoServico.altera(ordemServico);
		return lista();
	}
}
