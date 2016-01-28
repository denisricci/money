package br.com.money.controller;


import java.util.ResourceBundle;
import java.util.Set;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.money.utils.MessageUtils;

@Controller
public class MessageController {
			
	@Inject		
	private MessageUtils messages;
	
	@Inject
	private Result result;
	
	public void getJsonMessages(){
		ResourceBundle bundle = messages.getBundle();
		StringBuilder json = new StringBuilder();
		json.append("[");
		Set<String> keys = bundle.keySet();
		
		for(String key: keys){
			json.append("{key:'" + key + "', " + "value:'" + bundle.getString(key) + "'},");
		}
		
		int i = json.lastIndexOf(",");
		json.replace(i, i+1, "");
		json.append("]");
		result.use(Results.http()).body(json.toString());
	}
}
