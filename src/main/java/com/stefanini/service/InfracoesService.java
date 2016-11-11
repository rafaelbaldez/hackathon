package com.stefanini.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Agente;
import com.stefanini.model.Infracoes;
import com.stefanini.repository.InfracoesRepository;

@Stateless
public class InfracoesService {
	@Inject
	private InfracoesRepository infracoesRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Infracoes infracoes){
		infracoesRepository.incluir(infracoes);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ArrayList<Infracoes> listar(){
		return (ArrayList<Infracoes>) infracoesRepository.lista();
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Infracoes busca(int id){
		return infracoesRepository.busca(id);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deleta(Infracoes infracao){
		infracoesRepository.deleta(infracao);;
	}
}
