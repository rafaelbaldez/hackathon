package com.stefanini.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stefanini.model.Agente;
import com.stefanini.model.Infracoes;
import com.stefanini.service.AgenteService;
import com.stefanini.service.InfracoesService;

@Path("/infracao")
@RequestScoped
public class InfracaoController {

	@Inject
	private InfracoesService infracaoService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Infracoes> get() {
		return infracaoService.listar();
	}
	@POST
	 @Path("/deletar/{A1}")
	    //@Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public void deleta(@PathParam("A1")int id){
		 infracaoService.deleta(infracaoService.busca(id));
		 System.out.println("deletou o "+id);
	 }
}