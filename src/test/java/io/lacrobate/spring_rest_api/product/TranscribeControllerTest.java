package io.lacrobate.spring_rest_api.product;

import io.lacrobate.spring_rest_api.status.StatusController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TranscribeControllerTest {

	@LocalServerPort
	private int port;

	private String urlBase;
	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeAll
	void setUp() {
		urlBase = "http://localhost:8080/transcribe";
	}

	@Test
	@DisplayName("should return ACCEPTED when I call transcribe API")
	public void whenICallTranscribeAPI() {
		//    when
		String apiUnderTest = (urlBase + "/%s").formatted("testFile1");
		String result = restTemplate.getForObject(apiUnderTest, String.class);
		//    then
		assertEquals(result, "some result");
	}



}