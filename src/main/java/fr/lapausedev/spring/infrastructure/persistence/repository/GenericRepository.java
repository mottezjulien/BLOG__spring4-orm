package fr.lapausedev.spring.infrastructure.persistence.repository;

import fr.lapausedev.spring.infrastructure.exception.RepositoryException;

import java.util.List;

public interface GenericRepository<Entity, PrimaryKey> {

	Entity save(Entity entity) throws RepositoryException;

	void remove(Entity entity) throws RepositoryException;

	Entity findById(PrimaryKey id) throws RepositoryException;

	List<Entity> findAll() throws RepositoryException;

}