package com.vvs.springnewsparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootConfiguration
@SpringBootApplication
@EnableScheduling
public class SpringNewsParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNewsParserApplication.class, args);
	}

}
