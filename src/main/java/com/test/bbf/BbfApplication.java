package com.test.bbf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching//开启springboot对缓存的支持
public class BbfApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbfApplication.class, args);
	}

}

