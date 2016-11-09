package com.stefanini.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Tipoinfracao;
import com.stefanini.repository.TipoInfracaoRepository;

@Stateless
public class TipoInfracaoService {
	@Inject
	private TipoInfracaoRepository tipoInfracaoRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Tipoinfracao tipoInfracao){
		tipoInfracaoRepository.incluir(tipoInfracao);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ArrayList<Tipoinfracao> listar(){
		return (ArrayList<Tipoinfracao>) tipoInfracaoRepository.lista();
	}
}
