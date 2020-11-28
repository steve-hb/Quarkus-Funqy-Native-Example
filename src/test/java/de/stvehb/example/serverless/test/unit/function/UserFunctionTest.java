package de.stvehb.example.serverless.test.unit.function;

import de.stvehb.example.serverless.function.dto.UserDTO;
import io.quarkus.test.junit.QuarkusTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class UserFunctionTest {

	@Test
	public void testCreation() {
		UserDTO original = new UserDTO(null, "MyUsername");
		given()
			.body(original)
			.post("/createUser")
			.then()
			.statusCode(HttpStatus.SC_NO_CONTENT);
	}

	@Test
	public void testCreation_InvalidUsername() {
		given()
			.body(new UserDTO(null, "max"))
			.post("/createUser")
			.then()
			.statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR); // SC_BAD_REQUEST

		given()
			.body(new UserDTO(null, "ThisUsernameShouldBeTooLong"))
			.post("/createUser")
			.then()
			.statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);

		given()
			.body(new UserDTO(null, "                                        "))
			.post("/createUser")
			.then()
			.statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
	}

}
