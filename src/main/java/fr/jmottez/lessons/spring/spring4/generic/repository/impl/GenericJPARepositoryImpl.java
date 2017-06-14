package fr.jmottez.lessons.spring.spring4.generic.repository.impl;

import fr.jmottez.lessons.spring.spring4.generic.repository.GenericRepository;
import fr.jmottez.lessons.spring.spring4.generic.repository.RepositoryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;


public class GenericJPARepositoryImpl<Entity, PrimaryKey> implements GenericRepository<Entity, PrimaryKey> {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	private Class<Entity> entity;

	public GenericJPARepositoryImpl(Class<Entity> entityClass) {
		this.entity = entityClass;
	}

	@Override
	public Entity save(Entity entity) throws RepositoryException {
		try {
			getSession().save(entity);
		} catch (PersistenceException exception) {
			throw new RepositoryException(exception.getMessage(), exception);
		}
		return entity;
	}

	@Override
	public Entity update(Entity entity) throws RepositoryException {
		try {
			getSession().merge(entity);
		} catch (PersistenceException exception) {
			throw new RepositoryException(exception.getMessage(), exception);
		}

		return entity;
	}

	@Override
	public void remove(Entity entity) throws RepositoryException {
		try {
			getSession().remove(entity);
		} catch (PersistenceException exception) {
			throw new RepositoryException(exception.getMessage(), exception);
		}
	}

	@Override
	public void removeById(PrimaryKey id) throws RepositoryException {
		try {
			getSession().createQuery("delete from " + entity.getSimpleName() + " where id=" + id).executeUpdate();
		} catch (PersistenceException exception) {
			throw new RepositoryException(exception.getMessage(), exception);
		}

	}

	@Override
	public Entity findOne(PrimaryKey id) throws RepositoryException {
		try {
			return getSession().find(entity, id);
		} catch (PersistenceException exception) {
			throw new RepositoryException(exception.getMessage(), exception);
		}
	}

	@Override
	public List<Entity> findAll() throws RepositoryException {
		try {
			TypedQuery<Entity> query = getSession().createQuery("select t from " + entity.getSimpleName() + " t", entity);
			return query.getResultList();
		} catch (PersistenceException exception) {
			throw new RepositoryException(exception.getMessage(), exception);
		}
	}

}
