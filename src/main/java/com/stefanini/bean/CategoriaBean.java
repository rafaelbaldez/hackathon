package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Categoria;
@Named("categoriaMB")
@SessionScoped
public class CategoriaBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private CategoriaBean categoria;
	
	public ArrayList<Categoria> listar(){
		return categoria.listar();
	}
}
