package com.givsoft.gc.persistence.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.givsoft.gc.persistence.dao.DependenciaDAO;
import com.givsoft.gc.persistence.entity.Dependencia;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class DependenciaDAOHibernate extends
		AbstractDAOHibernate<Integer, Dependencia> implements DependenciaDAO {

}