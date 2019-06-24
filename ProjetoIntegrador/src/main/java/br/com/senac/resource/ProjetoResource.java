package br.com.senac.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.util.ManipulaJSON;

@RestController
@RequestMapping("/projeto")
public class ProjetoResource {

	@GetMapping("/getJson")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJson() {
		String retorno = "";
		ManipulaJSON mj = new ManipulaJSON();
		retorno = mj.getJSON("http://academico.rj.senac.br/pluginfile.php/2062/block_html/content/arquivogeojson.geojson");
		return Response.status(200).entity(retorno).build();
	}
}
