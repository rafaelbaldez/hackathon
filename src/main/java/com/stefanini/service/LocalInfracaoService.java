package com.stefanini.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Localinfracao;
import com.stefanini.repository.LocalInfracaoRepository;

@Stateless
public class LocalInfracaoService {
	@Inject
	private LocalInfracaoRepository localRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Localinfracao local){
		localRepository.incluir(local);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ArrayList<Localinfracao> listar(){
		return (ArrayList<Localinfracao>) localRepository.lista();
	}
}
