package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;


import com.stefanini.model.Proprietario;

public class ProprietarioRepository {
	@Inject
	private EntityManager manager;

	public void incluir(Proprietario proprietario) {
		this.manager.persist(proprietario);
	}

	public void altera(Proprietario proprietario) {
		this.manager.merge(proprietario);
	}

	public Proprietario busca(Integer id) {
		return this.manager.find(Proprietario.class, id);
	}

	public List<Proprietario> lista() {
		return this.manager.createQuery("select c from Proprietario c", Proprietario.class)
				.getResultList();
	}
}
