package com.senac.projetopadrao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProjetopadraoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetopadraoApplication.class, args);
	}

}
