package br.com.money.services;

import javax.inject.Inject;

import br.com.money.annotations.Transactional;
import br.com.money.dao.CashFlowDAO;
import br.com.money.entity.BankAccount;
import br.com.money.entity.Movement;

public class CashFlowServices {
	
	@Inject
	private CashFlowDAO dao;
	
	@Transactional
	public void bankPosting(Movement movement){		
		BankAccount bankAccount = dao.findById(movement.getIdBankAccount(), BankAccount.class);		
		bankAccount.setBalance(movement.calculateBalance(bankAccount.getBalance()));
		dao.save(movement);
	}
	
	
	
}
