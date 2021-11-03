package com.CoxExercise.Cox;

import org.junit.jupiter.api.Test;
import org.junit.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

//import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getStockTest() throws Exception {
		Assert.assertTrue(this.restTemplate.getForObject("http://localhost:" + port + "/stock?lookingItem=a",
				Object.class) != null);
	}

	@Test
	public void getStocksTest() throws Exception {
		Assert.assertTrue(this.restTemplate.getForObject("http://localhost:" + port + "/stocks?lookingItems=a,ac",
				Object.class) != null);
	}

	@Test
	public void getAverageTest() throws Exception {
		Assert.assertTrue(this.restTemplate.getForObject("http://localhost:" + port + "/average?lookingItems=a,ac",
				Object.class) != null);
	}
}