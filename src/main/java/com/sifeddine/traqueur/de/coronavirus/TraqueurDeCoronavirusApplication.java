package com.sifeddine.traqueur.de.coronavirus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TraqueurDeCoronavirusApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraqueurDeCoronavirusApplication.class, args);
	}

}
