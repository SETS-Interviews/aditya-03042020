package com.ibm.part;

import com.ibm.part.domain.PartNumber;
import com.ibm.part.repository.PartNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class PrefApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrefApplication.class, args);
	}
}
