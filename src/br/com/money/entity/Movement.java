package br.com.money.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.money.enums.Operation;

@Entity
public class Movement extends EntityBase<Integer>{
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Operation operation;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_bank_account", insertable = false, updatable = false)
	private BankAccount bankAccount;
	
	@Column(name="id_bank_account")
	private Integer idBankAccount;
	
	private String description;
		
	@ManyToOne(fetch=FetchType.EAGER)	
	private Category category;

	private BigDecimal value;
	
	private BigDecimal currentBalance;
		
	private Date date;
	
	public BigDecimal calculateBalance(BigDecimal balance){
		if(operation !=null && value !=null){
			this.currentBalance = balance.add(this.value);		
			return this.currentBalance;
		}		
		return null;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {		
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public BankAccount getBankAccount() {
		
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.idBankAccount=bankAccount.getId();
		this.bankAccount = bankAccount;
	}

	public Integer getIdBankAccount() {
		return idBankAccount;
	}

	public void setIdBankAccount(Integer idBankAccount) {
		this.idBankAccount = idBankAccount;
	}
}
