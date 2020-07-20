package fr.lapausedev.spring.user.persistence.repository;

import fr.lapausedev.spring.infrastructure.persistence.repository.GenericRepository;
import fr.lapausedev.spring.user.persistence.entity.UserEntity;

public interface UserRepository  extends GenericRepository<UserEntity, Integer> {

}
