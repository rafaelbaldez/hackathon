package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Categoria;
import com.stefanini.service.CategoriaService;
@Named("categoriaMB")
@RequestScoped
public class CategoriaBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private Categoria categoria;
	@Inject
	private CategoriaService categoriaService;
	
	 public String chamar(){
	    	categoriaService.incluir(categoria);
	    	return "/teste";
	    }
	
	public ArrayList<Categoria> listar(){
		return categoriaService.listar();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
