package com.stefanini.model;
// Generated 07/11/2016 12:04:55 by Hibernate Tools 4.3.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * Categoria generated by hbm2java
 */
@Entity
@Table(name = "categoria", catalog = "hackathon")
public class Categoria implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idCategoria", unique = true, nullable = false)
	private int idCategoria;
	@Column(name = "descricaiCategoria", length = 50)
	private String descricaiCategoria;
	@OneToMany(mappedBy="categoria")
	private List<Modelo> modelos = new ArrayList<Modelo>();
	

	

	public Categoria() {
	}

	public Categoria(String descricaiCategoria) {
		this.descricaiCategoria = descricaiCategoria;
	}

	
	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	
	public String getDescricaiCategoria() {
		return this.descricaiCategoria;
	}

	public void setDescricaiCategoria(String descricaiCategoria) {
		this.descricaiCategoria = descricaiCategoria;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(Modelo modelos) {
		this.modelos.add(modelos);
	}
	
	
	

}
