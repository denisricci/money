package br.com.money.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.money.annotations.Transactional;
import br.com.money.dao.CashFlowDAO;
import br.com.money.entity.BankAccount;
import br.com.money.entity.Category;
import br.com.money.entity.Movement;
import br.com.money.services.CashFlowServices;

@Controller
public class CashFlowController {
	
	@Inject
	private Result result;
	
	@Inject
	private CashFlowDAO dao;	
	
	@Inject
	private CashFlowServices cashFlowServices;
	
	public void forward(){
		result.forwardTo("../WEB-INF/html/cashFlow.html");
	}
	
	public void chooseAccount(){
		result.forwardTo("../WEB-INF/html/chooseAccount.html");
	}
	
	public void categoriesList(){
		List<Category> categories = dao.findAll(Category.class);
		result.use(Results.json()).from(categories).serialize();
	}
	
	public void movementsList(Integer accountId){
		List<Movement> movements = dao.findMovimentsByAccountId(accountId);
		result.use(Results.json()).from(movements).include("category").serialize();
	}
	
	public void accountById(Integer accountId){
		BankAccount account = dao.findById(accountId, BankAccount.class);
		result.use(Results.json()).from(account).include("bank").serialize();
	}
	
	@Transactional
	@Consumes("application/json")
	public void add(Movement movement){
		cashFlowServices.bankPosting(movement);
		result.use(Results.http()).setStatusCode(200);
	}
}
