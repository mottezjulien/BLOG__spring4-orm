package fr.jmottez.lessons.spring.spring4.user.repository.impl;


import fr.jmottez.lessons.spring.spring4.generic.repository.impl.GenericJPARepositoryImpl;
import fr.jmottez.lessons.spring.spring4.user.repository.UserRepository;
import fr.jmottez.lessons.spring.spring4.user.repository.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserRepositoryJPAImpl extends GenericJPARepositoryImpl<UserEntity, Integer> implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public UserRepositoryJPAImpl() {
		super(UserEntity.class);
	}

}

