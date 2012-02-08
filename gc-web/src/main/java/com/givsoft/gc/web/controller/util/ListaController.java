package com.givsoft.gc.web.controller.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.givsoft.gc.core.manager.EstadoManager;
import com.givsoft.gc.persistence.entity.Estado;

@ManagedBean(name = "Lista")
@SessionScoped
public class ListaController implements Serializable{
	
	private static final long serialVersionUID = 368707310625278881L;
	
	@ManagedProperty(value = "#{estadoManager}")
	private EstadoManager estadoManager;
	
	public EstadoManager getEstadoManager() {
		return estadoManager;
	}
	
	public void setEstadoManager(EstadoManager estadoManager) {
		this.estadoManager = estadoManager;
	}
	
	
	public List<SelectItem> getEstados() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(null, "Seleccione..."));
		for(Estado estado : estadoManager.getAll()) {
			items.add(new SelectItem(estado.getIdEstado(), estado.getNombre()));
		}
		return items;
	}
}
