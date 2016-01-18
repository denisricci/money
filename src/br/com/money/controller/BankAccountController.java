package br.com.money.controller;

import java.util.ArrayList;
import java.util.List;
import br.com.caelum.vraptor.Controller;
import br.com.money.entity.BankAccount;

@Controller
public class BankAccountController {
		
	public List<BankAccount> list(){
		System.out.println("acessou");
		return new ArrayList<BankAccount>();
	}

}
