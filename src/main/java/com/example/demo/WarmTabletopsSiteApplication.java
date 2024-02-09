package com.example.demo;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class WarmTabletopsSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarmTabletopsSiteApplication.class, args);
	}
}

