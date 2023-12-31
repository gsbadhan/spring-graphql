package com.example.springgraphql;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example.springgraphql"})
@Slf4j
public class SpringGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphqlApplication.class, args);
	}

}
