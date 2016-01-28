package br.com.money.interceptors;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.money.annotations.Transactional;

@Interceptor
@Transactional
@Priority(Interceptor.Priority.APPLICATION)
public class TransactionsManager {

	@Inject
	private EntityManager entityManager;

	@AroundInvoke
	public Object gerenciaTransacao(InvocationContext ic) {
		EntityTransaction tx = null;
		Object retorno;
		try {
			tx = entityManager.getTransaction();
			if (!tx.isActive()) {
				tx.begin();
			}
			retorno = ic.proceed();
			if (tx.isActive()) {
				tx.commit();
			}
			return retorno;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Erro na transacao" + e.getMessage());
		}
		return null;
	}
}
