package com.stefanini.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Proprietario;
import com.stefanini.repository.ProprietarioRepository;

@Stateless
public class ProprietarioService {
	@Inject
	private ProprietarioRepository proprietarioRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Proprietario proprietario){
		proprietarioRepository.incluir(proprietario);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ArrayList<Proprietario> listar(){
		return (ArrayList<Proprietario>) proprietarioRepository.lista();
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Proprietario busca(int id){
		return proprietarioRepository.busca(id);
	}
}
