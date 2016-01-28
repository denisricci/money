package br.com.money.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityBase<E> implements Serializable {			

	private static final long serialVersionUID = 1L;
		
	protected int excluido = 0;
	
	public abstract E getId();
	
	public abstract void setId(E id);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityBase<?> other = (EntityBase<?>) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	public int getExcluido() {
		return excluido;
	}

	public void setExcluido(int excluido) {
		this.excluido = excluido;
	}

}
