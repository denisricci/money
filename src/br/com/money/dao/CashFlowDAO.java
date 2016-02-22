package br.com.money.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import br.com.money.entity.Movement;

public class CashFlowDAO extends GenericDAO {

    public List<Movement> findMovimentsByAccountId(Integer accountId, Date startDate, Date endDate) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<Movement> query = cb.createQuery(Movement.class);
        Root<Movement> from = query.from(Movement.class);

        TypedQuery<Movement> typedQuery = getEntityManager().createQuery(query.select(from).
                where(cb.equal(from.get("idBankAccount"), accountId),
                        cb.and(cb.between(from.<Date>get("date"), startDate, endDate))));
        return typedQuery.getResultList();
    }

}
