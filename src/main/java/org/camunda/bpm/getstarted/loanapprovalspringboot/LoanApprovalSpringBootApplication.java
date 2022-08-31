package org.camunda.bpm.getstarted.loanapprovalspringboot;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class LoanApprovalSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanApprovalSpringBootApplication.class, args);
	}

}
