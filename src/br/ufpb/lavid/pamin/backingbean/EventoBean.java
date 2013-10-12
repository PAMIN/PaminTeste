package br.ufpb.lavid.pamin.backingbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufpb.lavid.pamin.controlador.ControladorEvento;
import br.ufpb.lavid.pamin.modelo.EventoInfo;

@ManagedBean(name="eventoBean")
@RequestScoped
public class EventoBean implements java.io.Serializable {

	private List<EventoInfo> listaInfoEventos; // Lista com informa��es de todos os eventos existentes no banco de dados
	private EventoInfo eventoDetalhe; // objeto com os detalhes do evento para exibi��o na p�gina detalhe.jsf
	private boolean listar = true; 
	private int idEvento; // id do evento escolhido para a pagina detalhe.jsf atribuido ao carregar a p�gina
	
	// Preenche a lista com objetos que possuem as informa��es de cada evento armazenado no banco de dados
	public List<EventoInfo> getListaInfoEventos() {
		if(listar) {
    	   ControladorEvento controlEvento = new ControladorEvento();
    	   listaInfoEventos = controlEvento.getListaInfoEventos(); // preenche lista com todos os eventos
    	   listar = false;
		}
		return listaInfoEventos;
	}
	
	// Busca evento a ser mostra na p�gina detalha.jsf a partir do id do evento que � atribuido pela par�metro da url
    public void buscaEventoDetalhe() {
		ControladorEvento control = new ControladorEvento();
		eventoDetalhe = control.getDetalheEvento(idEvento);
	}
    
    public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	
	public EventoInfo getEventoDetalhe() {
		return eventoDetalhe;
	}

}
