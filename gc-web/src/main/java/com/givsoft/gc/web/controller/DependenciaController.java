package com.givsoft.gc.web.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.givsoft.gc.core.manager.DependenciaManager;

@ManagedBean(name = "Dependencia")
@SessionScoped
public class DependenciaController implements Serializable {

	private static final long serialVersionUID = -5148575182342658716L;
	
	@ManagedProperty(value = "#{dependenciaManager}")
	private DependenciaManager dependenciaManager;
	
	public DependenciaManager getDependenciaManager() {
		return dependenciaManager;
	}
	
	public void setDependenciaManager(DependenciaManager dependenciaManager) {
		this.dependenciaManager = dependenciaManager;
	}
	
}