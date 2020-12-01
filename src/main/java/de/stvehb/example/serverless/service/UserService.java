package de.stvehb.example.serverless.service;

import de.stvehb.example.serverless.repository.UserRepository;
import de.stvehb.example.serverless.repository.model.UserModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserService {

	@Inject
	UserRepository userRepository;

	@Transactional
	public void createUser(String username) {
		this.userRepository.persist(new UserModel(null, username));
	}

}
