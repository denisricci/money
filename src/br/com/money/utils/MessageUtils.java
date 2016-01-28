package br.com.money.utils;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class MessageUtils implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("pt","BR"));
	
	public String getMessage(String key){						
		return bundle.getString("key");	
	}
	
	public ResourceBundle getBundle(){
		return this.bundle;
	}
}
