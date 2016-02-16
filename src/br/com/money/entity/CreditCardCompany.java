package br.com.money.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Ricci on 15/02/2016.
 */
@Entity
@Table(name = "credit_card_company")
public class CreditCardCompany extends EntityBase<Integer>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    private Integer id;

    private String name;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id=id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
