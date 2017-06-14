package fr.jmottez.lessons.spring.spring4.user.service;

import fr.jmottez.lessons.spring.spring4.user.domain.assembler.UserModelAssembler;
import fr.jmottez.lessons.spring.spring4.user.domain.model.UserModel;
import fr.jmottez.lessons.spring.spring4.user.repository.UserRepository;
import fr.jmottez.lessons.spring.spring4.user.repository.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserModelAssembler assembler;

	@Autowired
	private UserRepository repository;

	@Transactional
	public List<UserModel> findAll() {
		return assembler.fromEntities(repository.findAll());
	}

	@Transactional
	public UserModel save(UserModel model){
		UserEntity entity = assembler.toEntity(model);
		repository.save(entity);
		return assembler.fromEntity(entity);
	}

}
