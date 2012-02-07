package com.givsoft.gc.core.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.givsoft.gc.core.manager.PaisManager;
import com.givsoft.gc.persistence.dao.PaisDAO;
import com.givsoft.gc.persistence.entity.Pais;

@Component("paisManager")
@Transactional(propagation = Propagation.REQUIRED)
public class PaisManagerImpl extends AbstractManager<Integer, Pais, PaisDAO>
		implements PaisManager {

	@Autowired
	private PaisDAO dao;

	@Override
	public PaisDAO getDAO() {
		return dao;
	}

}
