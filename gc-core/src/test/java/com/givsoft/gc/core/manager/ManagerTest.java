package com.givsoft.gc.core.manager;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.givsoft.gc.core.CommonCoreTest;
import com.givsoft.gc.persistence.entity.Dependencia;

public class ManagerTest extends CommonCoreTest {
	
	@Autowired
	private DependenciaManager dependenciaManager;
	
	@Test
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Rollback(true)
	public void testSave() {
		Dependencia dependencia = new Dependencia();
		dependencia.setNombre("dependencia");
		dependenciaManager.save(dependencia);
	}

}
