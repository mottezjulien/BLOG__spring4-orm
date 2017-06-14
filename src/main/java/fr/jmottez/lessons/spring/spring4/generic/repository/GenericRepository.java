package fr.jmottez.lessons.spring.spring4.generic.repository;

import java.util.List;

public interface GenericRepository<Entity, PrimaryKey> {

	Entity save(Entity entity) throws RepositoryException;

	Entity update(Entity entity) throws RepositoryException;

	void remove(Entity entity) throws RepositoryException;

	void removeById(PrimaryKey id) throws RepositoryException;

	Entity findOne(PrimaryKey id) throws RepositoryException;

	List<Entity> findAll() throws RepositoryException;
	

}