package de.stvehb.example.serverless.repository;

import de.stvehb.example.serverless.repository.model.UserModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface UserRepository extends PanacheRepository<UserModel> {

	default UserModel findByUsername(String username) {
		return this.find("username", username).firstResult();
	}

}
