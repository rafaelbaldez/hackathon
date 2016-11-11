package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Modelo;
import com.stefanini.service.CategoriaService;
import com.stefanini.service.ModeloService;
@Named("modeloMB")
@RequestScoped
public class ModeloBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
    private Modelo modelo;

	@Inject
	private ModeloService modeloService;
	
	@Inject
	private CategoriaService categoriaService;
	
	private int idCat;
	
	
	public ArrayList<Modelo> listar(){
		return modeloService.listar();
	}
    public String chamar(){
    	modelo.setIdCategoria(categoriaService.busca(idCat));
    	modeloService.incluir(modelo);
    	return "/index";
    }
    
    public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public int getIdCat() {
		return idCat;
	}

	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}

	

}
