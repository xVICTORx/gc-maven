package com.givsoft.gc.persistence.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.givsoft.gc.persistence.dao.EstadoDAO;
import com.givsoft.gc.persistence.entity.Estado;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class EstadoDAOHibernate extends AbstractDAOHibernate<Integer, Estado>
		implements EstadoDAO {

}