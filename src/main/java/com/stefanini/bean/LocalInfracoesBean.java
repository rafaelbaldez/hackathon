package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Localinfracao;
import com.stefanini.service.LocalInfracaoService;

@Named("localMB")
@SessionScoped
public class LocalInfracoesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private Localinfracao localinfracao;
	@Inject
	private LocalInfracaoService localService;
	
	public ArrayList<Localinfracao> listar(){
		return localService.listar();
	}

	public Localinfracao getLocalinfracao() {
		return localinfracao;
	}

	public void setLocalinfracao(Localinfracao localinfracao) {
		this.localinfracao = localinfracao;
	}

}
