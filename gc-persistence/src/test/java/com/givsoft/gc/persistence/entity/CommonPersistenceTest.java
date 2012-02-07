package com.givsoft.gc.persistence.entity;

import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:persistenceApplicationContext.xml")
public class CommonPersistenceTest {

	@Autowired
	protected SessionFactory sessionFactory;

	@Test
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@SuppressWarnings("unchecked")
	public void entityTest() {
		Collection<SingleTableEntityPersister> entities = sessionFactory
				.getAllClassMetadata().values();
		System.out.println("*************************");
		System.out.println("Model Test");
		System.out.println("*************************");
		for (SingleTableEntityPersister entity : entities) {
			System.out.println("Testeando: " + entity.getTableName() + " ...");
			try {
				Query query = sessionFactory.getCurrentSession().createQuery(
						"from " + entity.getEntityName());
				Object o = query.setMaxResults(1).list();
				System.out.println("Resultado: \n " + o);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			System.out.println("*************************");
		}
	}

}
