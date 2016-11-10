package com.stefanini.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Agente;
import com.stefanini.repository.AgenteRepository;

@Stateless
public class AgenteService {
	@Inject
	private AgenteRepository agenteRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Agente agente){
		agenteRepository.incluir(agente);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ArrayList<Agente> listar(){
		return (ArrayList<Agente>) agenteRepository.lista();
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Agente busca(int id){
		return agenteRepository.busca(id);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void altera(Agente agente){
		agenteRepository.altera(agente);;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deleta(Agente agente){
		agenteRepository.deleta(agente);;
	}
}
