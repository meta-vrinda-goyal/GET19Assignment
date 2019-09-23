package com.metacube.assignment.EADAssignment11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class EadAssignment11Application {

	public static void main(String[] args) {
		SpringApplication.run(EadAssignment11Application.class, args);
	}

}
