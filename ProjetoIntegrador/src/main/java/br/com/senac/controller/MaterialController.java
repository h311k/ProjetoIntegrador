package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.Material;
import br.com.senac.servico.MaterialServico;
import br.com.senac.servico.exception.ObjectNotFoundException;

@Controller
@RequestMapping("/material")
public class MaterialController {

	@Autowired
	private MaterialServico materialServico;
	
	@GetMapping("/lista")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("material/administra");
		mv.addObject("materiais", materialServico.lista());
		return mv;
	}
	
	@GetMapping("/adiciona")
	public ModelAndView adiciona() {
		ModelAndView mv = new ModelAndView("material/adiciona");
		mv.addObject("material", new Material());
		return mv;
	}
	
	@PostMapping("/insere")
	public ModelAndView salva(Material material) {
		materialServico.insere(material);
		return lista();
	}
	
	@GetMapping("/exclui/{materialId}")
	public ModelAndView exclui(@PathVariable("materialId") Integer id) {
		materialServico.exclui(id);
		return lista();
	}
	
	@GetMapping("/altera/{materialId}")
	public ModelAndView altera(@PathVariable("materialId") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("material/altera");
		mv.addObject("material", materialServico.busca(id));
		return mv;
	}
	
	@PostMapping("/altera")
	public ModelAndView altera(Material material) throws ObjectNotFoundException {
		materialServico.altera(material);
		return lista();
	}
}
