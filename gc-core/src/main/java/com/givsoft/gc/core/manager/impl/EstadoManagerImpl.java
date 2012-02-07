package com.givsoft.gc.core.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.givsoft.gc.core.manager.EstadoManager;
import com.givsoft.gc.persistence.dao.EstadoDAO;
import com.givsoft.gc.persistence.entity.Estado;

@Component("estadoManager")
@Transactional(propagation = Propagation.REQUIRED)
public class EstadoManagerImpl extends
		AbstractManager<Integer, Estado, EstadoDAO> implements EstadoManager {

	@Autowired
	private EstadoDAO dao;

	@Override
	public EstadoDAO getDAO() {
		return dao;
	}

}