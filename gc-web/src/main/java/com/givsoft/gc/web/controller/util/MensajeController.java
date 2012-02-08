package com.givsoft.gc.web.controller.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "Mensaje")
public class MensajeController {
	
	public String getMensaje(ResourceBundle bundle, String property, String ...params) {
		String  msgValue = bundle.getString(property);
	    MessageFormat   messageFormat = new MessageFormat(msgValue);
		return messageFormat.format(params);
	}
}
