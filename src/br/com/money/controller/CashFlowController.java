package br.com.money.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.money.annotations.Transactional;
import br.com.money.dao.GenericDAO;
import br.com.money.entity.Category;
import br.com.money.entity.Movement;

@Controller
public class CashFlowController {
	
	@Inject
	private Result result;
	
	@Inject
	private GenericDAO dao;
	
	public void forward(){
		result.forwardTo("../WEB-INF/html/cashFlow.html");
	}
	
	public void categoriesList(){
		List<Category> categories = dao.findAll(Category.class);
		result.use(Results.json()).from(categories).serialize();
	}
	
	@Transactional
	@Consumes("application/json")
	public void add(Movement movement){
		dao.save(movement);
		result.use(Results.http()).setStatusCode(200);
	}
}
