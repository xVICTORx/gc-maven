package com.givsoft.gc.persistence.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.givsoft.gc.persistence.dao.PaisDAO;
import com.givsoft.gc.persistence.entity.Pais;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class PaisDAOHibernate extends AbstractDAOHibernate<Integer, Pais>
		implements PaisDAO {

}