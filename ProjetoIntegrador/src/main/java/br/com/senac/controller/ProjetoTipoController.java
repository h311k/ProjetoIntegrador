package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.ProjetoTipo;
import br.com.senac.service.ProjetoTipoService;
import br.com.senac.service.exception.ObjectNotFoundException;

@Controller
@RequestMapping("/projetotipo")
public class ProjetoTipoController {

	@Autowired
	private ProjetoTipoService ProjetoTipoService;
	
	@GetMapping("/lista")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("projetotipo/administra");
		mv.addObject("projetosTipo", ProjetoTipoService.listaTodos());
		return mv;
	}
	
	@GetMapping("/adiciona")
	public ModelAndView adiciona() {
		ModelAndView mv = new ModelAndView("projetotipo/adiciona");
		mv.addObject("projetoTipo", new ProjetoTipo());
		return mv;
	}
	
	@PostMapping("/insere")
	public ModelAndView salva(ProjetoTipo projetoTipo) {
		ProjetoTipoService.insere(projetoTipo);
		return lista();
	}
	
	@GetMapping("/exclui/{projetoTipoId}")
	public ModelAndView exclui(@PathVariable("projetoTipoId") Integer id) {
		ProjetoTipoService.excluir(id);
		return lista();
	}
	
	@GetMapping("/altera/{projetoTipoId}")
	public ModelAndView altera(@PathVariable("projetoTipoId") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("projetotipo/altera");
		mv.addObject("projetoTipo", ProjetoTipoService.busca(id));
		return mv;
	}
	
	@PostMapping("/altera")
	public ModelAndView altera(ProjetoTipo projetoTipo) throws ObjectNotFoundException {
		ProjetoTipoService.altera(projetoTipo);
		return lista();
	}
}
