package com.stefanini.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.service.AgenteService;
import com.stefanini.service.DenunciaService;

@Named("agenteMB")
@SessionScoped
public class AgenteBean implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
    private Agente agente;
    @Inject
	private AgenteService agenteService;
    

    public String chamar() {
        agenteService.incluir(agente);
    	return "/teste";
    }



	public Agente getAgente() {
		return agente;
	}



	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	

}