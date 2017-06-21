package fr.jmottez.lessons.spring.spring4.generic.repository.impl;

import fr.jmottez.lessons.spring.spring4.generic.repository.GenericRepository;
import fr.jmottez.lessons.spring.spring4.exception.RepositoryException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;


public class GenericJPARepositoryImpl<Entity, PrimaryKey> implements GenericRepository<Entity, PrimaryKey> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<Entity> entity;

	public GenericJPARepositoryImpl(Class<Entity> entityClass) {
		this.entity = entityClass;
	}

	@Override
	public Entity save(Entity entity) throws RepositoryException {
		try {
			entityManager.persist(entity);
		} catch (PersistenceException exception) {
			throw new RepositoryException(exception.getMessage(), exception);
		}
		return entity;
	}

	@Override
	public Entity update(Entity entity) throws RepositoryException {
		try {
			entityManager.merge(entity);
		} catch (PersistenceException exception) {
			throw new RepositoryException(exception.getMessage(), exception);
		}

		return entity;
	}

	@Override
	public void remove(Entity entity) throws RepositoryException {
		try {
			entityManager.remove(entity);
		} catch (PersistenceException exception) {
			throw new RepositoryException(exception.getMessage(), exception);
		}
	}

	@Override
	public void removeById(PrimaryKey id) throws RepositoryException {
		try {
			entityManager.createQuery("delete from " + entity.getSimpleName() + " where id=" + id).executeUpdate();
		} catch (PersistenceException exception) {
			throw new RepositoryException(exception.getMessage(), exception);
		}
	}

	@Override
	public Entity findById(PrimaryKey id) throws RepositoryException {
		try {
			return entityManager.find(entity, id);
		} catch (PersistenceException exception) {
			throw new RepositoryException(exception.getMessage(), exception);
		}
	}

	@Override
	public List<Entity> findAll() throws RepositoryException {
		try {
			TypedQuery<Entity> query = entityManager.createQuery("select t from " + entity.getSimpleName() + " t", entity);
			return query.getResultList();
		} catch (PersistenceException exception) {
			throw new RepositoryException(exception.getMessage(), exception);
		}
	}

}
