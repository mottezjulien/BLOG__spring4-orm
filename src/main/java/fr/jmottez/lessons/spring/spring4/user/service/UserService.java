package fr.jmottez.lessons.spring.spring4.user.service;

import fr.jmottez.lessons.spring.spring4.infrastructure.exception.ServiceException;
import fr.jmottez.lessons.spring.spring4.infrastructure.exception.RepositoryException;
import fr.jmottez.lessons.spring.spring4.user.domain.assembler.UserModelAssembler;
import fr.jmottez.lessons.spring.spring4.user.domain.model.UserModel;
import fr.jmottez.lessons.spring.spring4.user.persistence.repository.UserRepository;
import fr.jmottez.lessons.spring.spring4.user.persistence.entity.UserEntity;
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
	public UserModel save(UserModel model) throws ServiceException {
		try {
			UserEntity entity = assembler.toEntity(model);
			repository.save(entity);
			return assembler.fromEntity(entity);
		} catch (RepositoryException exception){
			throw new ServiceException(exception);
		}
	}

	@Transactional
	public List<UserModel> findAll() throws ServiceException {
		try {
			return assembler.fromEntities(repository.findAll());
		} catch (RepositoryException exception){
			throw new ServiceException(exception);
		}
	}

	@Transactional
	public UserModel findById(int id) throws ServiceException {
		try {
			return assembler.fromEntity(repository.findById(id));
		} catch (RepositoryException exception){
			throw new ServiceException(exception);
		}
	}

	@Transactional
	public void remove(UserModel model) throws ServiceException {
		if(model.getId() > 0){
			try {
				repository.remove(repository.findById(model.getId()));
			} catch (RepositoryException exception){
				throw new ServiceException(exception);
			}
		} else {
			throw new ServiceException(new IllegalArgumentException("Removing a existing entity:" + model));
		}
	}
}
