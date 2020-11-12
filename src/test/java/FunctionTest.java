import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
public class FunctionTest {

	@Test
	public void testHelloWorld() {
		given()
			.get("/helloWorld")
		.then()
			.statusCode(200)
			.body(equalTo("\"Hello World\""));
	}

}
