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
}
