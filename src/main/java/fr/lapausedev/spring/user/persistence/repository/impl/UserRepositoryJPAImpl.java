package fr.lapausedev.spring.user.persistence.repository.impl;


import fr.lapausedev.spring.infrastructure.persistence.repository.impl.GenericJPARepositoryImpl;
import fr.lapausedev.spring.user.persistence.repository.UserRepository;
import fr.lapausedev.spring.user.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryJPAImpl extends GenericJPARepositoryImpl<UserEntity, Integer> implements UserRepository {

		public UserRepositoryJPAImpl() {
		super(UserEntity.class);
	}

}

