package com.ibyte.rhapi;

import com.ibyte.rhapi.models.Departament;
import com.ibyte.rhapi.models.Employer;
import com.ibyte.rhapi.repositories.DepartamentRepository;
import com.ibyte.rhapi.repositories.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class IDepartamentApplication {

	@Autowired
	private DepartamentRepository departamentRepository;

	@Autowired
	private EmployerRepository employerRepository;

	public static void main(String[] args) {
		SpringApplication.run(IDepartamentApplication.class, args);
	}

}
