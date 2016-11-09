package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Veiculos;
import com.stefanini.service.VeiculosService;

@Named("veiculoMB")
@SessionScoped
public class VeiculosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private Veiculos veiculos;
	@Inject
	private VeiculosService veiculoService;
	
	public ArrayList<Veiculos> listar(){
		return veiculoService.listar();
	}

	public Veiculos getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Veiculos veiculos) {
		this.veiculos = veiculos;
	}

}
