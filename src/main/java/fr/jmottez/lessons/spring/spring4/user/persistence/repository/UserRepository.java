package fr.jmottez.lessons.spring.spring4.user.persistence.repository;

import fr.jmottez.lessons.spring.spring4.infrastructure.persistence.repository.GenericRepository;
import fr.jmottez.lessons.spring.spring4.user.persistence.entity.UserEntity;

public interface UserRepository  extends GenericRepository<UserEntity, Integer> {

}
