package br.com.money.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.money.annotations.Transactional;
import br.com.money.dao.GenericDAO;
import br.com.money.entity.EntityBase;

@Controller
public abstract class GenericController <E extends EntityBase<?>> {
	
	@Inject
	protected Result result;
	
	@Inject
	protected GenericDAO dao;			
	
	
	@Transactional
	public void save(E entity){
		dao.save(entity);		
	}
	
	@Transactional
	@Consumes("application/json")
	public void remove(E entity){
		dao.remove(entity.getId(), entity.getClass());
		result.use(Results.http()).setStatusCode(200);
	}
}
