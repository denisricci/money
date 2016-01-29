package br.com.money.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BankAccount extends EntityBase<Integer>{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue	
	private Integer id;
	private String description;	
	private double balance;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Bank bank;
		
	public Bank getBank() {
		return bank;
	}	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
