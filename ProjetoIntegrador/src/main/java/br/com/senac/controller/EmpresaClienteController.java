package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.EmpresaCliente;
import br.com.senac.service.EmpresaClienteService;
import br.com.senac.service.exception.ObjectNotFoundException;

@Controller
@RequestMapping("/empresacliente")
public class EmpresaClienteController {

	@Autowired
	private EmpresaClienteService empresaClienteService;
	
	@GetMapping("/lista")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("empresaCliente/administra");
		mv.addObject("empresasCliente", empresaClienteService.listaTodos());
		return mv;
	}
	
	@GetMapping("/adiciona")
	public ModelAndView adiciona() {
		ModelAndView mv = new ModelAndView("empresaCliente/adiciona");
		mv.addObject("empresaCliente", new EmpresaCliente());
		return mv;
	}
	
	@PostMapping("/insere")
	public ModelAndView salva(EmpresaCliente empresaCliente) {
		empresaClienteService.insere(empresaCliente);
		return lista();
	}
	
	@GetMapping("/exclui/{empresaClienteId}")
	public ModelAndView exclui(@PathVariable("empresaClienteId") Integer id) {
		empresaClienteService.excluir(id);
		return lista();
	}
	
	@GetMapping("/altera/{empresaClienteId}")
	public ModelAndView altera(@PathVariable("empresaClienteId") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("empresacliente/altera");
		mv.addObject("empresaCliente", empresaClienteService.busca(id));
		return mv;
	}
	
	@PostMapping("/altera")
	public ModelAndView altera(EmpresaCliente empresaCliente) throws ObjectNotFoundException {
		empresaClienteService.altera(empresaCliente);
		return lista();
	}
}
