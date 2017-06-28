package fr.jmottez.lessons.spring.spring4.user.persistence.repository;

import fr.jmottez.lessons.spring.spring4.generic.persistence.repository.GenericRepository;
import fr.jmottez.lessons.spring.spring4.user.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends GenericRepository<UserEntity, Integer> {

}
