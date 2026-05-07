package com.kartik.tickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
public class TicketsApplication {

	public static void main(String[] args) {
        SpringApplication.run(TicketsApplication.class, args);
	}

}
