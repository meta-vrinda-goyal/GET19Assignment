package com.metacube.assignment.EADSession12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class EadSession12Application {

	public static void main(String[] args) {
		SpringApplication.run(EadSession12Application.class, args);
	}

}
