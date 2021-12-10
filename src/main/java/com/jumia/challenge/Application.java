package com.jumia.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jumia.challenge.api.domain.dao.CustomerDao;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerDao customerDao;	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		customerDao.findAll();
	}

}
