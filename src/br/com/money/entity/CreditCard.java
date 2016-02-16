package br.com.money.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
* @author Ricci
* 16 de fev de 2016
*/
public class CreditCard extends EntityBase<Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private Integer id;
	private Date invoiceDate;
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private CreditCardCompany company;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_bank_account", insertable = false, updatable = false)
	private BankAccount bankAccount;
	
	@Column(name="id_bank_account")
	private Integer idBankAccount;
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CreditCardCompany getCompany() {
		return company;
	}

	public void setCompany(CreditCardCompany company) {
		this.company = company;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
}
