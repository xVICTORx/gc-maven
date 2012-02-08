package com.givsoft.gc.web.controller.catalogo.dependencia;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.givsoft.gc.core.lazydatamodel.LazyDependenciaDataModel;
import com.givsoft.gc.core.manager.DependenciaManager;
import com.givsoft.gc.persistence.entity.Dependencia;
import com.givsoft.gc.persistence.entity.Estado;

@ManagedBean(name = "Dependencia")
@SessionScoped
public class DependenciaController implements Serializable {

	private static final long serialVersionUID = -5148575182342658716L;

	@ManagedProperty(value = "#{lazyDependenciaDataModel}")
	private LazyDependenciaDataModel dataModel;
	@ManagedProperty(value = "#{dependenciaManager}")
	private DependenciaManager dependenciaManager;

	private Boolean isOpenAddDialog = Boolean.FALSE;
	private Dependencia dependencia = new Dependencia();

	public DependenciaController() {
		super();
		dependencia = new Dependencia();
		dependencia.setEstado(new Estado());
	}

	public LazyDependenciaDataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(LazyDependenciaDataModel dataModel) {
		this.dataModel = dataModel;
	}

	public DependenciaManager getDependenciaManager() {
		return dependenciaManager;
	}

	public void setDependenciaManager(DependenciaManager dependenciaManager) {
		this.dependenciaManager = dependenciaManager;
	}

	public void setIsOpenAddDialog(Boolean isOpenAddDialog) {
		this.isOpenAddDialog = isOpenAddDialog;
	}

	public Boolean getIsOpenAddDialog() {
		return isOpenAddDialog;
	}

	public Dependencia getDependencia() {
		return dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		if (dependencia != null) {
			this.dependencia = dependencia;
		}
	}

	public void openAddDialog() {
		setIsOpenAddDialog(Boolean.TRUE);
	}

	public void closeAddDialog() {
		setIsOpenAddDialog(Boolean.FALSE);
	}

	public void editDependencia() {
		if (dependencia != null && dependencia.getIdDependencia() != null) {
			setIsOpenAddDialog(Boolean.TRUE);
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Seleccione un registro del la tabla!",
							"Seleccione un registro del la tabla!"));
		}
	}

	public void addDependencia() {
		dependencia = new Dependencia();
		dependencia.setEstado(new Estado());
		setIsOpenAddDialog(Boolean.TRUE);
	}

	public void saveDependencia() {
		try {
			dependenciaManager.save(dependencia);
			setIsOpenAddDialog(Boolean.FALSE);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Guardado correctamente!",
							"Guardado correctamente!"));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Error al guardar!", "Error al guardar!"));
		}

	}

	public void delDependencia() {
		if (dependencia != null && dependencia.getIdDependencia() != null) {
			try {
				dependenciaManager.delete(dependencia);
				setIsOpenAddDialog(Boolean.FALSE);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Eliminado correctamente!",
								"Eliminado correctamente!"));
			} catch (Exception e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error al eliminar!", "Error al eliminar!"));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Seleccione un registro del la tabla!",
							"Seleccione un registro del la tabla!"));
		}

	}

}