package br.com.senac.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@GetMapping("/autentica")
	public ModelAndView autentica(RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("colaborador/autentica");
		mv.addObject("colaborador", new Colaborador());
		return mv;
	}
	
	@PostMapping("/login")
	public String login(Colaborador colaborador, RedirectAttributes redirectAttributes) {
		if (colaborador.getUsuario().equals("") || colaborador.getSenha().equals("")) {
			redirectAttributes.addFlashAttribute("mensagem", "Os campos de usuário e senha são obrigatórios.");
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		} else {
			redirectAttributes.addFlashAttribute("mensagem", "Novo usuário criado com sucesso.");
			redirectAttributes.addFlashAttribute("alertClass", "alert-success");
			colaborador = colaboradorServico.findUsuarioSenha(colaborador);
			if (colaborador == null) {
				redirectAttributes.addFlashAttribute("mensagem", "Nome de usuário ou senha inválidos.");
				redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			} else {
				redirectAttributes.addFlashAttribute("mensagem", "Novo usuário autenticado com sucesso.");
				redirectAttributes.addFlashAttribute("alertClass", "alert-success");
			}
		}
		return "redirect:/colaborador/autentica";
	}
	
	@PostMapping("/autenticausuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuario(Colaborador colaborador) {

		colaborador = colaboradorServico.findUsuarioSenha(colaborador);
		ObjectMapper mapper = new ObjectMapper();
		String jsonRetorno = "";
		try {
			jsonRetorno = mapper.writeValueAsString(colaborador);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(jsonRetorno).build();
	}
}
