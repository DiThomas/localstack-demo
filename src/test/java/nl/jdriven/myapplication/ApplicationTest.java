package nl.jdriven.myapplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
class ApplicationTest {

	@Test
	void contextLoads() {
//		when().request("GET", "/api/ping").then().statusCode(200).body("questionId" ,  equalTo("010917"));
	}

}
