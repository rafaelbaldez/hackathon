package com.stefanini.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.model.Proprietario;
import com.stefanini.service.ProprietarioService;

@Named("propietarioMB")
@SessionScoped
public class ProprietarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
    private Proprietario proprietario;
	
	@Inject
	private ProprietarioService proprietarioService;
    
    public String chamar() {
        proprietarioService.incluir(proprietario);
    	return "/teste";
    }
    
    public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

}
