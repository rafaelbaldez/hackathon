package com.stefanini.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import com.stefanini.model.Tipo;
//import com.stefanini.service.TipoService;

@Path("/tipo")
@RequestScoped
public class TipoController {

	/*@Inject
	private TipoService tipoService;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tipo> get() {
        return tipoService.listar();
    }*/
}
