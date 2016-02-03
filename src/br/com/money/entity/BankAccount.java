package br.com.money.entity;

import java.math.BigDecimal;

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
	private BigDecimal balance;
	private int number;
	private int agency;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Bank bank;
		
	public Bank getBank() {
		return bank;
	}	
	public void setBank(Bank bank) {
		this.bank = bank;
	}	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getAgency() {
		return agency;
	}
	public void setAgency(int agency) {
		this.agency = agency;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
