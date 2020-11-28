package de.stvehb.example.serverless.test.unit.function;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * This test demonstrates how to write unit tests for functions.
 */
@QuarkusTest
public class HelloWorldFunctionTest {

	@Test
	public void testHelloWorld() {
		given()
			.get("/helloWorld")
			.then()
			.statusCode(200)
			.body(equalTo("\"Hello World\""));
	}

}
