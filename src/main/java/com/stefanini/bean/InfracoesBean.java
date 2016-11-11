package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.stefanini.model.Infracoes;
import com.stefanini.model.Localinfracao;
import com.stefanini.model.Veiculos;
import com.stefanini.service.AgenteService;
import com.stefanini.service.InfracoesService;
import com.stefanini.service.TipoInfracaoService;
import com.stefanini.service.VeiculosService;

@Named("infracaoMB")
@SessionScoped()
public class InfracoesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private Infracoes infracoes;
	@Inject
	private InfracoesService infracoesService;
	@Inject
	private AgenteService agenteService;
	@Inject
	private TipoInfracaoService tipoInfracaoService;
	@Inject
	private Localinfracao local;
	@Inject
	private VeiculosService veiculoService;
	private int agente;
	private int tipo;
	private String placa;
	private LatLng latlng;
	
	private MapModel advancedModel;
	
	private MapModel cadastroModel;
	  
    private Marker marker;
  
    
    public String mostrarInfracoes() {
    	//cadastroModel = new DefaultMapModel();
    	advancedModel = new DefaultMapModel();
        ArrayList<Infracoes> infracoes= infracoesService.listar();
        for(Infracoes x : infracoes){
        	LatLng cord= new LatLng(x.getIdLocalInfracao().getLatitude(), x.getIdLocalInfracao().getLongitude());
        	System.out.println("ate aqui veio");
        	String mensagem= "Agente: "+x.getIdAgente().getNome()+"\nTipo de Infracao: "+x.getIdTipoInfracao().getDescricaoTipoInfracao()+
        			" Placa do Veiculo:"+x.getVeiculo().getPlaca();
        	advancedModel.addOverlay(new Marker(cord, mensagem));		
        }
        return "/listarInfracao.xhtml?faces-redirect=true";
    }
  
    public MapModel getAdvancedModel() {
        return advancedModel;
    }
    
      
    public MapModel getCadastroModel() {
		return cadastroModel;
	}

	public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }
      
    public Marker getMarker() {
        return marker;
    }

	public ArrayList<Infracoes> listar(){
		return infracoesService.listar();
	}
	 public String chamar() {
		 	Veiculos v = veiculoService.buscar(placa);
		 	if(v==null){
		 		return "/erro";
		 	}else{
		 	infracoes.setVeiculo(v);
		 	infracoes.setIdTipoInfracao(tipoInfracaoService.busca(tipo));
		 	local.setLatitude(latlng.getLat());
		 	local.setLongitude(latlng.getLng());
		 	infracoes.setIdLocalInfracao(local);
		 	infracoes.setIdAgente(agenteService.busca(agente));;
	    	infracoesService.incluir(infracoes);
	    	return mostrarInfracoes();
		 	}
	    }
	 
	 public void onPointSelect(PointSelectEvent event) {
	        latlng = event.getLatLng();
	        
	        cadastroModel = new DefaultMapModel();
	        cadastroModel.addOverlay(new Marker(latlng));
	        
	        
	 }
	 

	public Infracoes getInfracoes() {
		return infracoes;
	}

	public void setInfracoes(Infracoes infracoes) {
		this.infracoes = infracoes;
	}

	public Localinfracao getLocal() {
		return local;
	}

	public void setLocal(Localinfracao local) {
		this.local = local;
	}

	public int getAgente() {
		return agente;
	}

	public void setAgente(int agente) {
		this.agente = agente;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	

}
