package app.service;

import java.io.Serializable;

public interface BaseService<PK, T> {
	public T findById(Serializable key);

	default T saveOrUpdate(T entity) {
		return null;
	}

	public boolean delete(T entity);
	
}
