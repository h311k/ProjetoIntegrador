package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Projeto;
import br.com.senac.service.ProjetoService;
import br.com.senac.service.exception.ObjectNotFoundException;

@Controller
@RequestMapping("/projeto")
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;
	
	@GetMapping("/lista")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("projeto/administra");
		mv.addObject("projetos", projetoService.listaTodos());
		return mv;
	}
	
	@GetMapping("/adiciona")
	public ModelAndView adiciona() {
		ModelAndView mv = new ModelAndView("projeto/adiciona");
		mv.addObject("projeto", new Projeto());
		return mv;
	}
	
	@PostMapping("/insere")
	public ModelAndView salva(Projeto projeto) {
		projetoService.insere(projeto);
		return lista();
	}
	
	@GetMapping("/exclui/{projetoId}")
	public ModelAndView exclui(@PathVariable("projetoId") Integer id) {
		projetoService.excluir(id);
		return lista();
	}
	
	@GetMapping("/altera/{projetoId}")
	public ModelAndView altera(@PathVariable("projetoId") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("empresacliente/altera");
		mv.addObject("projeto", projetoService.busca(id));
		return mv;
	}
	
	@PostMapping("/altera")
	public ModelAndView altera(Projeto projeto) throws ObjectNotFoundException {
		projetoService.altera(projeto);
		return lista();
	}
}
