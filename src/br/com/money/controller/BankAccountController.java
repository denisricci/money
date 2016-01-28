package br.com.money.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.money.annotations.Transactional;
import br.com.money.dao.GenericDAO;
import br.com.money.entity.Bank;
import br.com.money.entity.BankAccount;

@Controller
public class BankAccountController implements Serializable{	
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Result result;
	
	@Inject
	private GenericDAO dao;			
	
	@Transactional
	public void save(BankAccount bankAccount){
		dao.save(bankAccount);
		result.redirectTo("/BankAccount.html");
	}
	
	public void list(){
		List<BankAccount> accounts = dao.findAll(BankAccount.class);
		result.use(Results.json()).from(accounts).include("bank").serialize();
	}
	
	public void bankList(){		
		List<Bank> banks = dao.findAll(Bank.class);
		result.use(Results.json()).from(banks).include("id").serialize();		
	}

}
