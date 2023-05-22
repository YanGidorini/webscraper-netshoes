package com.netshoes.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class WebscraperNetshoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebscraperNetshoesApplication.class, args);

		log.info("SERVIDOR INICIADO");
	}

}
