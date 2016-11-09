package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Infracoes;
import com.stefanini.service.InfracoesService;

@Named("infracoesMB")
@SessionScoped
public class InfracoesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private Infracoes infracoes;
	@Inject
	private InfracoesService infracoesService;
	
	public ArrayList<Infracoes> listar(){
		return infracoesService.listar();
	}

	public Infracoes getInfracoes() {
		return infracoes;
	}

	public void setInfracoes(Infracoes infracoes) {
		this.infracoes = infracoes;
	}

}
