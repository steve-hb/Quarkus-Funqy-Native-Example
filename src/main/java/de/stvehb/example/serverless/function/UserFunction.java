package de.stvehb.example.serverless.function;

import de.stvehb.example.serverless.function.dto.UserDTO;
import de.stvehb.example.serverless.service.UserService;
import io.quarkus.funqy.Funq;

import javax.inject.Inject;
import javax.validation.Valid;

public class UserFunction {

	@Inject
	private UserService userSer;

	@Funq
	public void createUser(@Valid UserDTO userDTO) {
		System.out.println(userDTO);
		this.userSer.createUser(userDTO.getUsername());
	}

}
