package br.com.biblioteca.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.biblioteca.bean.LivroBean;
import br.com.biblioteca.model.Livro;

@Path("livro")
public class LivroRest {

	@EJB
	private LivroBean livroBean;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserir(Livro livro) {
		try {
			livro = livroBean.inserir(livro);
			return Response.ok(livro).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build()
;		}
	}

}
