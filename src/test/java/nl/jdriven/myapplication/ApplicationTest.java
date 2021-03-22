package nl.jdriven.myapplication;

import nl.jdriven.myapplication.in.rest.MyRestController;
import nl.jdriven.myapplication.out.storage.model.Answer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
class ApplicationTest {

	@Autowired
	MyRestController myRestController;

	@Test
	void contextLoads() {
		Answer result = myRestController.pingPong();
		assertThat(result.getQuestionId()).isEqualTo("010917");
	}

}
