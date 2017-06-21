package fr.jmottez.lessons.spring.spring4.user.repository.impl;


import fr.jmottez.lessons.spring.spring4.generic.repository.impl.GenericJPARepositoryImpl;
import fr.jmottez.lessons.spring.spring4.user.repository.UserRepository;
import fr.jmottez.lessons.spring.spring4.user.domain.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryJPAImpl extends GenericJPARepositoryImpl<UserEntity, Integer> implements UserRepository {

		public UserRepositoryJPAImpl() {
		super(UserEntity.class);
	}

}
