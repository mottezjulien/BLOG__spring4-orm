package fr.jmottez.lessons.spring.spring4.user.domain.assembler;

import fr.jmottez.lessons.spring.spring4.user.domain.model.UserModel;
import fr.jmottez.lessons.spring.spring4.user.repository.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserModelAssembler {

	public List<UserModel> fromEntities(List<UserEntity> entities) {
		return entities.stream()
				.map(entity -> fromEntity(entity))
				.collect(Collectors.toList());
	}

	public UserModel fromEntity(UserEntity entity) {
		UserModel model = new UserModel();
		model.setId(entity.getId());
		model.setFirstName(entity.getFirstName());
		model.setLastName(entity.getLastName());
		return model;
	}

	public UserEntity toEntity(UserModel model) {
		UserEntity entity = new UserEntity();
		entity.setId(model.getId());
		entity.setFirstName(model.getFirstName());
		entity.setLastName(model.getLastName());
		return entity;
	}
}
