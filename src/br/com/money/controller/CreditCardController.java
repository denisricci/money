package br.com.money.controller;

import java.io.Serializable;
import java.util.List;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.money.annotations.Transactional;
import br.com.money.dao.GenericDAO;
import br.com.money.entity.CreditCard;
import br.com.money.entity.CreditCardCompany;

import javax.inject.Inject;

/**
 * @author Ricci
 *         16 de fev de 2016
 */

@Controller
public class CreditCardController implements Serializable {


    @Inject
    private GenericDAO dao;

    @Inject
    private Result result;

    @Consumes("application/json")
    @Transactional
    public void save(CreditCard creditCard) {
            dao.save(creditCard);
        result.use(Results.http()).setStatusCode(200);
    }

    public void list() {
        List<CreditCard> creditCards = dao.findAll(CreditCard.class, "bankAccount", "company");
        result.use(Results.json()).from(creditCards).include("bankAccount").include("company").serialize();
    }

    public void companies() {
        result.use(Results.json()).from(dao.findAll(CreditCardCompany.class)).serialize();
    }

    @Transactional
    @Consumes("application/json")
    public void remove(CreditCard creditCard) {
        dao.remove(creditCard.getId(), CreditCard.class);
        result.use(Results.http()).setStatusCode(200);
    }

}
