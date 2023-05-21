package com.example.vivo_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.vivo_backend.mapper")
public class VivoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(VivoBackendApplication.class, args);
	}

}
