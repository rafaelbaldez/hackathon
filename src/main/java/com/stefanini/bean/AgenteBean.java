package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.convert.NumberConverter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.event.PopupMenuListener;

import org.primefaces.model.chart.PieChartModel;

import com.stefanini.model.Agente;
import com.stefanini.model.Tipoinfracao;
import com.stefanini.service.AgenteService;

@Named("agenteMB")
@RequestScoped
public class AgenteBean implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
    private Agente agente;
    @Inject
	private AgenteService agenteService;
    
    private PieChartModel pieModel1;
    
    public PieChartModel populaRelatorio(){
    	pieModel1= new PieChartModel();
    	ArrayList<Agente> agentes=agenteService.listar();
    	for(Agente x: agentes){
    		System.out.println(x.getNome()+x.getInfracoes().size());
    		pieModel1.set(x.getNome(),x.getInfracoes().size());
    		
    	}
    	pieModel1.setTitle("Infrações de cada Agente");
		pieModel1.setLegendPosition("w");
		return pieModel1;
    }
    
    public String chamar() {
    	agenteService.incluir(agente);
    	return "/index";
    }
    
    public ArrayList<Agente> listar(){
		return agenteService.listar();
	}


	public Agente getAgente() {
		return agente;
	}



	public void setAgente(Agente agente) {
		this.agente = agente;
	}
	


	

}