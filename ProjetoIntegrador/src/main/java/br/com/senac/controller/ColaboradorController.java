package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Colaborador;
import br.com.senac.service.ColaboradorService;
import br.com.senac.service.exception.ObjectNotFoundException;

@Controller
@RequestMapping("/colaborador")
public class ColaboradorController {

	@Autowired
	private ColaboradorService colaboradorServico;
	
	@GetMapping("/lista")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("colaborador/administra");
		mv.addObject("colaboradores", colaboradorServico.listaTodos());
		return mv;
	}
	
	@GetMapping("/adiciona")
	public ModelAndView adiciona() {
		ModelAndView mv = new ModelAndView("colaborador/adiciona");
		mv.addObject("colaborador", new Colaborador());
		return mv;
	}
	
	@PostMapping("/insere")
	public ModelAndView salva(Colaborador colaborador) {
		colaboradorServico.insere(colaborador);
		return lista();
	}
	
	@GetMapping("/exclui/{colaboradorId}")
	public ModelAndView exclui(@PathVariable("colaboradorId") Integer id) {
		colaboradorServico.excluir(id);
		return lista();
	}
	
	@GetMapping("/altera/{colaboradorId}")
	public ModelAndView altera(@PathVariable("colaboradorId") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("colaborador/altera");
		mv.addObject("colaborador", colaboradorServico.busca(id));
		return mv;
	}
	
	@PostMapping("/altera")
	public ModelAndView altera(Colaborador colaborador) throws ObjectNotFoundException {
		colaboradorServico.altera(colaborador);
		return lista();
	}
}
