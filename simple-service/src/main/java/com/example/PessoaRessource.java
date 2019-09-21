package com.example;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("pessoas")
public class PessoaRessource {

	private PessoaService pessoaService = new PessoaService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/")
	public List<Pessoa> listPessoas() throws SQLException {
		return pessoaService.listPessoas();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("{id}/")
	public List<Pessoa> getPessoa(@PathParam("id") long id) throws SQLException {
		return pessoaService.getPessoa(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Pessoa pessoa) throws SQLException  {
		pessoaService.create(pessoa);
		return Response.status(Response.Status.OK).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/{id}")
	public Response update(@PathParam("id") long id, Pessoa pessoa) throws SQLException {
		pessoaService.update(id, pessoa);
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/{id}")
	public Response delete(@PathParam("id") long id) throws SQLException {
		pessoaService.delete(id);
		return Response.status(Response.Status.OK).build();
	}
}
