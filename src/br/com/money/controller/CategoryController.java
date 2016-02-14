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

@Controller
public class CategoryController {

	@Inject
	private Result result;
	
	@Inject
	private GenericDAO dao;
	
	@Transactional
	@Consumes("application/json")
	public void save(Category category){
		dao.save(category);		
		result.use(Results.json()).from(category.getId()).serialize();
	}
	
	public void list(){
		List<Category> entities = dao.findAll(Category.class);
		result.use(Results.json()).from(entities).serialize();
	}
	
	@Transactional
	@Consumes("application/json")
	public void remove(Category category){
		dao.remove(category.getId(), category.getClass());
		result.use(Results.http()).setStatusCode(200);
	}
}
