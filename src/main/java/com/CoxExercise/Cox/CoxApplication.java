package com.CoxExercise.Cox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//import com.CoxExercise.Services.*;

@SpringBootApplication
@ComponentScan({"com.CoxExercise.Services"})
public class CoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoxApplication.class, args);
	}

}
