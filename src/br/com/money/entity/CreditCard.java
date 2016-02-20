package br.com.money.entity;

import java.util.Date;

import javax.persistence.*;

/**
 * @author Ricci
 *         16 de fev de 2016
 */
@Entity
public class CreditCard extends EntityBase<Integer> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;
    private Integer invoiceDay;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private CreditCardCompany company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bank_account")
    private BankAccount bankAccount;

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

    public Integer getInvoiceDay() {
        return invoiceDay;
    }

    public void setInvoiceDay(Integer invoiceDay) {
        this.invoiceDay = invoiceDay;
    }


}
