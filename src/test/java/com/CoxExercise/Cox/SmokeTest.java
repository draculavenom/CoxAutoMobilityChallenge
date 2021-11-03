package com.CoxExercise.Cox;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.CoxExercise.Services.AutoMobilityController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private AutoMobilityController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}