package com.stefanini.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Modelo;
import com.stefanini.repository.ModeloRepository;

@Stateless
public class ModeloService {
	@Inject
	private ModeloRepository modeloRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Modelo modelo){
		modeloRepository.incluir(modelo);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ArrayList<Modelo> listar(){
		return (ArrayList<Modelo>) modeloRepository.lista();
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Modelo busca(int id){
		return modeloRepository.busca(id);
	}
}
