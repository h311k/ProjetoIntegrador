package br.com.senac.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.senac.domain.Colaborador;
import br.com.senac.service.ColaboradorService;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@Autowired
	private ColaboradorService colaboradorServico;
	
	@PostMapping("/autentica")
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
