package com.stefanini.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Categoria;
import com.stefanini.repository.CategoriaRepository;

@Stateless
public class CategoriaService {
	@Inject
	private CategoriaRepository categoriaRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Categoria categoria){
		categoriaRepository.incluir(categoria);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ArrayList<Categoria> listar(){
		return (ArrayList<Categoria>) categoriaRepository.lista();
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Categoria busca(int id){
		return categoriaRepository.busca(id);
	}
}
