package com.udaaninterview.limitedtimedeals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udaaninterview.limitedtimedeals.service.DealService;
import com.udaaninterview.limitedtimedeals.service.DealServiceImpl;

@SpringBootApplication
public class LimitedtimedealsApplication {
	public static void main(String[] args) {
		SpringApplication.run(LimitedtimedealsApplication.class, args);
	}

}
