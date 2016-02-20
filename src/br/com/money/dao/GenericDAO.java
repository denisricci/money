package br.com.money.dao;

import java.util.List;

import javax.annotation.Priority;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.money.entity.EntityBase;

@RequestScoped
@Alternative @Priority(Interceptor.Priority.APPLICATION + 1) 
public class GenericDAO {

	@Inject
	private EntityManager entityManager;
	
	public void save(EntityBase<?> Entity) {
		getEntityManager().persist(Entity);
	}
	
	public void save(List<?> Entitys) {
		for (Object obj : Entitys) {
			if (obj instanceof EntityBase) {
				save((EntityBase<?>) obj);
			}
		}
	}
	
	public void update(EntityBase<?> entity) {
		getEntityManager().merge(entity);
	}
	
	public <E> void remove(Object id, Class<E> classe) throws EntityNotFoundException {
		Query query = getEntityManager().createQuery("update " + classe.getSimpleName() + " set excluido = 1 where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
	
	public <E> void reallyRemove(Object id, Class<E> classe) throws EntityNotFoundException {
		Query query = getEntityManager().createQuery("delete from " + classe.getSimpleName() + " where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	public <E> E findById(Object id, Class<E> classe) {
		return getEntityManager().find(classe, id);
	}
		
	public <E> List<E> findAll(Class<E> classe) {
		TypedQuery<E> query = getEntityManager().createQuery("from " + classe.getSimpleName() + " where excluido = 0", classe);		
		return query.getResultList();
	}

	public <E> List<E> findAll(Class<E> classe, String ... fetchColuns) {
		StringBuilder sql = new StringBuilder("from " + classe.getSimpleName() + " e ");
		for(String colum : fetchColuns){
			sql.append(" join fetch e.");
			sql.append(colum);
		}
		sql.append(" where e.excluido = 0") ;

		TypedQuery<E> query = getEntityManager().createQuery(sql.toString(), classe);
		return query.getResultList();
	}
	
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
}
