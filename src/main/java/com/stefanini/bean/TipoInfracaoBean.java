package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Tipoinfracao;
import com.stefanini.service.TipoInfracaoService;

@Named("tipoInfracaoMB")
@SessionScoped
public class TipoInfracaoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private Tipoinfracao tipoInfracao;
	@Inject
	private TipoInfracaoService tipoInfracaoService;
	
	public ArrayList<Tipoinfracao> listar(){
		return tipoInfracaoService.listar();
	}

	public Tipoinfracao getTipoInfracao() {
		return tipoInfracao;
	}

	public void setTipoInfracao(Tipoinfracao tipoInfracao) {
		this.tipoInfracao = tipoInfracao;
	}

}
