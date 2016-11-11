package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Veiculos;
import com.stefanini.service.ModeloService;
import com.stefanini.service.ProprietarioService;
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
	@Inject
	private ProprietarioService proprietarioService;
	@Inject 
	private ModeloService modeloService;
	
	private int idProprietario;
	private int idModelo;
	
	public String chamar(){
    	veiculos.setIdModelo(modeloService.busca(idModelo));
    	veiculos.setProprietario(proprietarioService.busca(idProprietario));
    	veiculoService.incluir(veiculos);
    	return "/index";
    }
	
	public ArrayList<Veiculos> listar(){
		return veiculoService.listar();
	}

	public Veiculos getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Veiculos veiculos) {
		this.veiculos = veiculos;
	}

	public int getIdProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(int idProprietario) {
		this.idProprietario = idProprietario;
	}

	public int getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}
	
}
