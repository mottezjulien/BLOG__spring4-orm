package fr.jmottez.lessons.spring.spring4.user.repository;

import fr.jmottez.lessons.spring.spring4.generic.repository.GenericRepository;
import fr.jmottez.lessons.spring.spring4.user.domain.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends GenericRepository<UserEntity, Integer> {

}
