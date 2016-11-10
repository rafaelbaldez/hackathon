package com.stefanini.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stefanini.model.Agente;
import com.stefanini.service.AgenteService;

@Path("/agente")
@RequestScoped
public class AgenteController {

	@Inject
	private AgenteService agenteService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Agente> get() {
		return agenteService.listar();
	}
	
	 @POST
	 @Path("/atualizar")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public String alterarAgente(Agente agente) {
	    	agenteService.altera(agente);
	    	return "Agente cadastrado com sucesso!";
	    }
	 @POST
	 @Path("/deletar/{A1}")
	    //@Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public void deleta(@PathParam("A1")int id){
		 agenteService.deleta(agenteService.busca(id));
		 System.out.println("deletou o "+id);
	 }
	 @POST
	 @Path("/cadastrar")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public void cadastraAgente(Agente agente) {
	    	agenteService.incluir(agente);
	    	
	    }
	 
	/* @POST
		@Path("/cadastrarAgente")
		@Produces(MediaType.APPLICATION_JSON)
		public ServiceResponse cadastrarAgente(Agente agente)throws NegocioException {
			ServiceResponse resposta = null;
				try {
				ServiceResponse<Agente> retorno = new ServiceResponse<Agente>(service.salvar(agente));
				resposta = new ServiceResponse<Agente>();
				resposta = retorno;
			} catch (Exception e) {
		 resposta = new  ServiceResponse<Response>(Response.status(411).entity( e.getMessage()).build());
	         resposta = new ServiceResponse<Agente>();
		}
		return resposta;
	}*/



}
