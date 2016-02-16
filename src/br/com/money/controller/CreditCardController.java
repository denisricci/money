package br.com.money.controller;

import java.io.Serializable;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.money.entity.CreditCard;

/**
* @author Ricci
* 16 de fev de 2016
*/

@Controller
public class CreditCardController implements Serializable{
		
	private static final long serialVersionUID = 1L;

	@Consumes("application/json")
	public void save(CreditCard creditCard){
		
	}

}
