package com.givsoft.gc.core.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.givsoft.gc.core.manager.DependenciaManager;
import com.givsoft.gc.persistence.dao.DependenciaDAO;
import com.givsoft.gc.persistence.entity.Dependencia;

@Component("dependenciaManager")
@Transactional(propagation = Propagation.REQUIRED)
public class DependenciaManagerImpl extends
		AbstractManager<Integer, Dependencia, DependenciaDAO> implements
		DependenciaManager {
	
	public DependenciaManagerImpl() {
		super();
		System.out.println("Cargando dependencia manager");
	}

	@Autowired
	private DependenciaDAO dao;

	@Override
	public DependenciaDAO getDAO() {
		return dao;
	}

}
