package fr.jmottez.lessons.spring.spring4.user.persistence.repository.impl;


import fr.jmottez.lessons.spring.spring4.infrastructure.persistence.repository.impl.GenericJPARepositoryImpl;
import fr.jmottez.lessons.spring.spring4.user.persistence.repository.UserRepository;
import fr.jmottez.lessons.spring.spring4.user.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryJPAImpl extends GenericJPARepositoryImpl<UserEntity, Integer> implements UserRepository {

		public UserRepositoryJPAImpl() {
		super(UserEntity.class);
	}

}

