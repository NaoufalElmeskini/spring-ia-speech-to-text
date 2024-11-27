package io.lacrobate.spring_rest_api.status;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StatusControllerTest {
	WireMockServer wireMockServer = new WireMockServer();

	@BeforeAll
	public void setUp() {
		wireMockServer.start();
	}

	@Test
	@DisplayName("should XXX when I YYY")
	public void whenITryToXXX() {
		//    when


		//    then
		Assertions.assertThat(false).isTrue();
	}


}