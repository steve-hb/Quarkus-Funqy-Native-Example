package de.stvehb.example.serverless.test.unit.repository;

import de.stvehb.example.serverless.repository.UserRepository;
import de.stvehb.example.serverless.repository.model.UserModel;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.DisabledOnNativeImage;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This test demonstrates how to write a unit tests for repositories/models.
 */
@QuarkusTest
@DisabledOnNativeImage
@QuarkusTestResource(H2DatabaseTestResource.class)
public class RepositoryTest {

	@Inject
	private UserRepository userRepository;

	@Test
	@Transactional
	public void testRepository() {
		UserModel original = new UserModel(null, "NiceUsername");
		this.userRepository.persist(original);

		UserModel generated = this.userRepository.findByUsername(original.getUsername());
		assertNotNull(generated, "User model not persisted");
		assertEquals(original.getUsername(), generated.getUsername(), "Username wrong");
	}

}
